package com.example.yunpan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.yunpan.entity.Enums.*;
import com.example.yunpan.entity.FileInfo;
import com.example.yunpan.entity.UserInfo;
import com.example.yunpan.entity.dto.UploadResultDto;
import com.example.yunpan.mapper.FileInfoMapper;
import com.example.yunpan.service.IFileInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.yunpan.service.IUserInfoService;
import com.example.yunpan.util.*;
import freemarker.template.utility.DateUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author baomidou
 * @since 2023-06-27
 */
@Service
@Transactional
public class FileInfoServiceImpl extends ServiceImpl<FileInfoMapper, FileInfo> implements IFileInfoService {
    @Autowired
    IUserInfoService userInfoService;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    @Lazy
    FileInfoServiceImpl fileInfoService;
    @Override
    public Page<FileInfo> getFileByCategory(String userId, int categoryId, Integer pageNo, Integer pageSize,String pid,String fileName) {
        LambdaQueryWrapper<FileInfo> wrapper=new LambdaQueryWrapper<>();
        wrapper.like(!StringUtils.isEmpty(fileName),FileInfo::getFileName,fileName);
        wrapper.eq(categoryId!=-1,FileInfo::getFileCategory,categoryId);
        wrapper.eq(FileInfo::getUserId,userId);
        wrapper.eq(FileInfo::getFilePid,pid);
        wrapper.eq(FileInfo::getDelFlag,FileStatus.FILE_USE.getStatus());
        Page<FileInfo> page=new Page<>(pageNo,pageSize);
        page(page, wrapper);
        return page;
    }

    @Override
    public FileInfo getFile(String userId, String fileId, String filePid) {
        LambdaQueryWrapper<FileInfo> wrapper=new LambdaQueryWrapper();
        wrapper.eq(FileInfo::getUserId,userId);
        wrapper.eq(filePid!=null,FileInfo::getFilePid,filePid);
        wrapper.eq(FileInfo::getFileId,fileId);
        FileInfo one = this.getOne(wrapper);
        return one;
    }

    @Override
    public void removeFile(String userId, String fileId, String filePid) {
        LambdaQueryWrapper<FileInfo> wrapper=new LambdaQueryWrapper();
        wrapper.eq(FileInfo::getUserId,userId);
        wrapper.eq(FileInfo::getFilePid,filePid);
        wrapper.eq(FileInfo::getFileId,fileId);
        remove(wrapper);
    }

    @Override
    public Boolean deleteOneFile(String userId, String fileId, String fileType, String filePid) {
        LambdaQueryWrapper<FileInfo> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(FileInfo::getUserId,userId);
        wrapper.eq(FileInfo::getFileId,fileId);
        wrapper.eq(FileInfo::getFileType,fileType);
        wrapper.eq(FileInfo::getFilePid,filePid);
        FileInfo one = this.getOne(wrapper);
        one.setDelFlag((byte)FileStatus.FILE_RECOVER.getStatus());
        boolean remove = this.remove(wrapper);
        this.save(one);
        return remove;

    }

    @Override
    public Boolean moveFileToRecycleBin(String userId, String fileId, String fileType, String filePid) {
        LambdaQueryWrapper<FileInfo> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(FileInfo::getUserId,userId);
        wrapper.eq(FileInfo::getFileId,fileId);
        wrapper.eq(FileInfo::getFileType,fileType);
        wrapper.eq(FileInfo::getFilePid,filePid);
        FileInfo fileInfo = this.getOne(wrapper);
        if(fileInfo!=null){
            this.remove(wrapper);
            fileInfo.setDelFlag((byte)FileStatus.FILE_RECOVER.getStatus());
            this.save(fileInfo);
            return true;
        }
        return false;
    }

    @Override
    public UploadResultDto uploadFile(UserInfo userInfo,String fileId, MultipartFile file, String fileName, String filePid, String fileMd5, Integer chunkIndex, Integer chunks) throws GlobalException {
        Integer userSpace = this.baseMapper.getUserSpace(userInfo.getUserId());
        Boolean uploadSuccess=true;
        File tempFileFolder=null;
        try{
            UploadResultDto uploadResultDto=new UploadResultDto();
            if(chunkIndex==0){
                LambdaQueryWrapper<FileInfo> wrapper=new LambdaQueryWrapper<>();
                wrapper.eq(FileInfo::getFileMd5,fileMd5);
                wrapper.eq(FileInfo::getStatus, (byte)FileStoreStatus.USING.getStatus());
                List<FileInfo> files = list(wrapper);
                if(StringUtils.isEmpty(fileId))
                    fileId= RandomCode.getRandomCode(6);
//            秒传
                if(!files.isEmpty()){
                    FileInfo fileInfo=files.get(0);
                    if(userSpace+fileInfo.getFileSize()>userInfo.getTotalSpace()){
                        uploadSuccess=false;
                        throw new GlobalException("网盘空间不足，请扩容");
                    }
                    fileInfo.setFileId(fileId);
                    fileInfo.setFilePid(filePid);
                    fileInfo.setUserId(userInfo.getUserId());
                    fileInfo.setCreateTime(LocalDateTime.now());
                    fileInfo.setLastUpdateTime(LocalDateTime.now());
                    fileInfo.setStatus((byte)FileStoreStatus.USING.getStatus());
                    fileInfo.setDelFlag((byte)FileStatus.FILE_USE.getStatus());
                    fileInfo.setFileMd5(fileMd5);
                    fileName=renameFile(filePid,userInfo.getUserId(),fileName);
                    fileInfo.setFileName(fileName);
                    this.save(fileInfo);
                    uploadResultDto.setFileId(fileId);
                    uploadResultDto.setStatus(FileResultStatus.UPLOAD_SECONDS.getCode());
                    userInfoService.updateUserSpace(userInfo.getUserId(),fileInfo.getFileSize());
                    return uploadResultDto;
                }

            }
            String tempFolderName=Constants.FILE_PATH+Constants.TEMP_PATH;
            String currentUserFolderName=userInfo.getUserId()+fileId;
            tempFileFolder=new File(tempFolderName+currentUserFolderName);
            String key=Constants.UPLOADED_SIZE+fileId+userInfo.getUserId();
            Long uploadedSize =handleUploadSize(redisTemplate.opsForValue().get(key));
            if(uploadedSize!=null){

                long currentSpace=file.getSize()+uploadedSize+getUserSpace(userInfo.getUserId());
                long totalSpace=userInfo.getTotalSpace();
                if(currentSpace>totalSpace){
                    uploadSuccess=false;
                    throw new GlobalException("网盘空间不足");
                }
                redisTemplate.opsForValue().set(key,uploadedSize+file.getSize(),30, TimeUnit.MINUTES);
            }else {
                redisTemplate.opsForValue().set(key,file.getSize(),30,TimeUnit.MINUTES);
            }

            if(!tempFileFolder.exists()){
                tempFileFolder.mkdirs();
            }
            File newFile=new File(tempFileFolder.getPath()+"/"+chunkIndex);
            file.transferTo(newFile);

        if(chunkIndex<chunks-1){
            uploadResultDto.setStatus(FileResultStatus.UPLOADING.getCode());
            uploadResultDto.setFileId(fileId);
            return uploadResultDto;
        }
        uploadResultDto.setStatus(FileResultStatus.UPLOAD_FINISH.getCode());
        uploadResultDto.setFileId(fileId);
        String month= DateFormat.dateFormat(LocalDateTime.now(),"yyyyMM");
        String fileSuffix=StringTools.getFileNameSuffix(fileName);
//        真实文件名
        String realFileName=currentUserFolderName+fileSuffix;
        FileTypeBySuffix fileTypeBySuffix=FileTypeBySuffix.getFileBySuffix(fileSuffix);
        fileName=renameFile(filePid,userInfo.getUserId(),fileName);
        FileInfo fileInfo=new FileInfo();
        fileInfo.setFileId(fileId);
        fileInfo.setUserId(userInfo.getUserId());
        fileInfo.setFileMd5(fileMd5);
        fileInfo.setFileName(fileName);
        fileInfo.setFilePath(Constants.FILE_PATH+month+"/"+realFileName);
        fileInfo.setFilePid(filePid);
        fileInfo.setCreateTime(LocalDateTime.now());
        fileInfo.setLastUpdateTime(LocalDateTime.now());
        fileInfo.setFileCategory((byte)fileTypeBySuffix.getCategory().getCategoryCode());
        fileInfo.setFileType((byte)((int)fileTypeBySuffix.getType()));
        fileInfo.setStatus((byte)FileStoreStatus.TRANSFER.getStatus());
        fileInfo.setFolderType((byte)IsFolder.N.getCode());
        fileInfo.setDelFlag((byte)FileStatus.FILE_USE.getStatus());
        this.save(fileInfo);
        Long fileTotalSize=handleUploadSize(redisTemplate.opsForValue().get(key));
        userInfoService.updateUserSpace(userInfo.getUserId(),fileTotalSize);
            TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
                @Override
                public void afterCommit() {

                    fileInfoService.transferFile(fileInfo.getFileId(),userInfo);
                }
            });
        return uploadResultDto;
        }catch (Exception e){
            uploadSuccess=false;
            if(e instanceof GlobalException)
                throw new GlobalException(e.getMessage());
            else
                throw new GlobalException("文件上传失败");

        }finally {
            if(!uploadSuccess&&tempFileFolder!=null){
                try {
                    FileUtils.deleteDirectory(tempFileFolder);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }


        }
    }
    private String renameFile(String filePid,String userId,String fileName){
        LambdaQueryWrapper<FileInfo> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(FileInfo::getUserId,userId);
        wrapper.eq(FileInfo::getFilePid,filePid);
        wrapper.eq(FileInfo::getFileName,fileName);
        long count = count(wrapper);
        if(count>0){
            fileName= StringTools.rename(fileName);
        }
        return fileName;
    }
    public Long handleUploadSize(Object size){
        if(size instanceof Integer){
            return (long)((int)size);
        }else if (size instanceof Long){
            return (Long)size;
        }else {
            return null;
        }
    }
    @Override
    public Integer getUserSpace(String userId) {
        return this.baseMapper.getUserSpace(userId);
    }

    @Override
    public FileInfo saveFolder(String folderName, String userId, String filePid) {
        FileInfo fileInfo=new FileInfo();
        fileInfo.setFileId(RandomCode.getRandomString(10));
        fileInfo.setUserId(userId);
        fileInfo.setFilePid(filePid);
        fileInfo.setFileName(folderName);
        fileInfo.setFileType((byte)FileType.FOLDER.getType());
        fileInfo.setFolderType((byte)IsFolder.Y.getCode());
        fileInfo.setCreateTime(LocalDateTime.now());
        fileInfo.setLastUpdateTime(LocalDateTime.now());
         fileInfo.setStatus((byte)FileStoreStatus.USING.getStatus());
         fileInfo.setDelFlag((byte)FileStatus.FILE_USE.getStatus());
         save(fileInfo);
         return fileInfo;
    }

    @Override
    public List<FileInfo> getFolderInfo(String path, String userId) {
        String[] pathArray=path.split("/");
        String order="filed(file_id,\""+pathArray[0];
        for (int i = 1; i <pathArray.length ; i++) {
            order+="\",\""+pathArray[i];
        }
        order+="\")";
        List<FileInfo> folderInfo = this.baseMapper.getFolderInfo(userId,Arrays.stream(pathArray).toList(),order);
        return folderInfo;
    }

    @Override
    public void changeFileFolder(String fileIds, String filePid, String userId) throws GlobalException {
        if(fileIds.equals(filePid)){
             throw new GlobalException("参数错误");
        }
        if(!filePid.equals("0")){
            FileInfo file = fileInfoService.getFile(userId, filePid, null);
            if(file==null||!(FileStatus.FILE_USE.getStatus()==file.getStatus())){
                throw new GlobalException("参数错误");
            }
        }
        String[] fileArray=fileIds.split(",");
        LambdaQueryWrapper<FileInfo> fileInfoWrapper=new LambdaQueryWrapper<>();
        fileInfoWrapper.eq(FileInfo::getFilePid,filePid);
        fileInfoWrapper.eq(FileInfo::getUserId,userId);
        List<FileInfo> list = this.list(fileInfoWrapper);
        Map<String,FileInfo> dbFileNameMap=list.stream().collect(Collectors.toMap(FileInfo::getFileName, Function.identity(),(data1,data2)->data2));
        fileInfoWrapper=new LambdaQueryWrapper<>();
        fileInfoWrapper.eq(FileInfo::getUserId,userId);
        fileInfoWrapper.in(FileInfo::getFileId, Arrays.stream(fileArray).toList());
        List<FileInfo> fileInfos = this.list(fileInfoWrapper);
        for (FileInfo fileInfo:fileInfos) {
            FileInfo rootFileInfo=dbFileNameMap.get(fileInfo.getFileName());
            removeFile(fileInfo.getUserId(),fileInfo.getFileId(),fileInfo.getFilePid());

            if(rootFileInfo!=null){
                String fileName=StringTools.rename(fileInfo.getFileName());
                fileInfo.setFileName(fileName);
            }
            fileInfo.setFilePid(filePid);
            this.save(fileInfo);
        }
    }

    @Async
    public void transferFile(String fileId,UserInfo userInfo){
        Boolean transferSuccess=true;
        String targetFilePath=null;
        FileTypeBySuffix fileTypeBySuffix=null;
        FileInfo fileInfo=this.getFile(userInfo.getUserId(),fileId,null);
        try{
            if(fileInfo==null||!(FileStoreStatus.TRANSFER.getStatus()==((int)fileInfo.getStatus()))){
                return ;
            }
//            临时目录
            String tempFolderName=Constants.FILE_PATH+Constants.TEMP_PATH;
            String currentUserFolderName=userInfo.getUserId()+fileId;
            File fileFolder=new File(tempFolderName+currentUserFolderName);
            String fileSuffix=StringTools.getFileNameSuffix(fileInfo.getFileName());
            String month=DateFormat.dateFormat(fileInfo.getCreateTime(),"yyyyMM");

//          目标目录
            String targetFolderName=Constants.FILE_PATH+Constants.REAL_PATH;
            File targetFolder=new File(targetFolderName+"/"+month);
            if(!targetFolder.exists()){
                targetFolder.mkdirs();
            }
            String realFileName=currentUserFolderName+fileSuffix;
            targetFilePath=targetFolder.getPath()+"/"+realFileName;
//            合并文件
            union(fileFolder.getPath(),targetFilePath,fileInfo.getFileName(),true);
//            视频文件切割

        }catch (Exception e){
            transferSuccess=false;
        }finally {
            LambdaQueryWrapper<FileInfo> wrapper=new LambdaQueryWrapper<>();
            wrapper.eq(FileInfo::getFileId,fileInfo.getFileId());
            wrapper.eq(FileInfo::getUserId,fileInfo.getUserId());
            FileInfo one = getOne(wrapper);
            one.setFileSize(new File(targetFilePath).length());
            one.setStatus((byte)(transferSuccess?FileStoreStatus.USING.getStatus():FileStoreStatus.TRANSFER_FAIL.getStatus()));
            remove(wrapper);
            save(one);
        }
    }
    public void union(String dirPath,String toFilePath,String fileName,Boolean delSource) throws GlobalException {
        File dir=new File(dirPath);
        if(!dir.exists()){
            throw new GlobalException("目录不存在");
        }
        File[] fileList=dir.listFiles();
        File targetFile=new File(toFilePath);
        RandomAccessFile writeFile=null;
        try{
            writeFile=new RandomAccessFile(targetFile,"rw");
            byte[] b=new byte[1024*10];
            for (int i = 0; i < fileList.length; i++) {
                int len=-1;
                File chunkFile=new File(dirPath+"/"+i);
                RandomAccessFile readFile=null;
                try{
                    readFile=new RandomAccessFile(chunkFile,"r");
                    while((len=readFile.read(b))!=-1){
                        writeFile.write(b,0,len);
                    }
                }catch (Exception e){
                    throw new GlobalException("合并分片失败");
                }finally {
                    readFile.close();
                }
            }
        }catch (Exception e){
            throw new GlobalException("合并文件失败");
        }finally {
            if(null!=writeFile){
                try {
                    writeFile.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
            if(delSource&&dir.exists()){
                try {
                    FileUtils.deleteDirectory(dir);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
