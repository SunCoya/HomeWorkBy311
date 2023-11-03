package com.example.yunpan.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.yunpan.entity.Enums.FileStatus;
import com.example.yunpan.entity.Enums.IsFolder;
import com.example.yunpan.entity.FileInfo;
import com.example.yunpan.entity.UserInfo;
import com.example.yunpan.entity.dto.UploadResultDto;
import com.example.yunpan.service.IFileInfoService;
import com.example.yunpan.entity.Enums.FileType;
import com.example.yunpan.util.GlobalException;
import com.example.yunpan.util.Result;
import com.example.yunpan.util.StringTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author baomidou
 * @since 2023-06-27
 */
@RestController
@RequestMapping("/fileInfo")
public class FileInfoController {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    IFileInfoService fileInfoService;

    @GetMapping("/queryAll")//获取文件
    public Result getAllFile(HttpSession session,
                             @RequestParam("category") int category ,
                             @RequestParam("pageNo") Integer pageNo,
                             @RequestParam("pageSize") Integer pageSize,
                             @RequestParam("filePid") String filePid,
                             @RequestParam("fileName") String fileName){

        UserInfo userInfo =getUserInfo(session);
        String userId=userInfo.getUserId();
        Page<FileInfo> fileByCategory = fileInfoService.getFileByCategory(userId, category,pageNo,pageSize,filePid,fileName);
        return Result.build(fileByCategory,"查询成功",200);
    }
    //创建文件夹
    @PostMapping("/buildFolder")
    public Result buildFolder(HttpSession session,
                              @RequestParam("folderName") String folderName,
                              @RequestParam("filePid" ) String filePid) {
        UserInfo userInfo=getUserInfo(session);
        String userId=userInfo.getUserId();
        try {
            checkFileName(folderName,filePid,userId,FileType.FOLDER);
        } catch (GlobalException e) {
                return Result.build(null,e.getMessage(),201);
        }
        FileInfo fileInfo = fileInfoService.saveFolder(folderName, userId, filePid);
        return Result.build(fileInfo,"文件夹创建成功",200);
    }
    //检查是否重名
    public void checkFileName(String folderName, String filePid, String userId, FileType fileType) throws GlobalException {
        LambdaQueryWrapper<FileInfo> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(FileInfo::getFileName,folderName);
        wrapper.eq(FileInfo::getFilePid,filePid);
        wrapper.eq(FileInfo::getUserId,userId);
        wrapper.eq(FileInfo::getFileType,fileType);
        FileInfo one = fileInfoService.getOne(wrapper);
        if(one!=null){
            throw new GlobalException("操作失败！！！\n同级目录下，同名文件已存在");
        }
    }
    @PutMapping("/renameFile")
    public Result renameFile(HttpSession session,@RequestParam("fileId") String fileId,
                             @RequestParam("fileName") String newName,
                             @RequestParam("filePid") String filePid,
                             @RequestParam("fileType")  int fileType) {


        UserInfo userInfo =getUserInfo(session);
        String userId=userInfo.getUserId();
        try {
            checkFileName(newName,filePid,userId,FileType.findEnumByCode(fileType));
        } catch (GlobalException e) {
            return Result.build(null,e.getMessage(),201);
        }
        FileInfo file = fileInfoService.getFile(userId, fileId, filePid);
        if(file==null){
            return Result.build(null,"文件不存在或已被删除,修改失败",201);
        }
        String fileNameSuffix = StringTools.getFileNameSuffix(file.getFileName());

        file.setFileName(newName+fileNameSuffix);
        file.setLastUpdateTime(LocalDateTime.now());
        fileInfoService.removeFile(userId, fileId, filePid);
        fileInfoService.save(file);
        return Result.build(null,"修改成功",200);

    }
    //文件移入回收站
    @DeleteMapping("/moveFileToRecycle")
    public Result moveFileToRecycle(HttpSession session,
                                    @RequestParam("fileId") String fileId,
                                    @RequestParam("fileType") String fileType,
                                    @RequestParam("filePid") String filePid){

        UserInfo userInfo = getUserInfo(session);
        String userId=userInfo.getUserId();
        Boolean isMove=fileInfoService.moveFileToRecycleBin(userId, fileId, fileType, filePid);
        if(isMove){
            return Result.build(null,"删除成功",200);
        }else{
            return Result.build(null,"删除失败",201);
        }
    }
    //批量移入回收站
    @DeleteMapping("/moveMoreFileToRecycle")
    public Result moveMoreFileToRecycle(HttpSession session,@RequestBody List<FileInfo> fileInfoList){
        UserInfo userInfo=getUserInfo(session);
        for (FileInfo fileInfo: fileInfoList) {
            fileInfo.setUserId(userInfo.getUserId());
           fileInfoService.moveFileToRecycleBin(fileInfo.getUserId(),fileInfo.getFileId().toString(),fileInfo.getFileType().toString(),fileInfo.getFilePid());
        }
        return Result.build(null,"删除成功",200);
    }
    //文件删除
    @DeleteMapping("/deleteFile")
    public Result deleteFile(HttpSession session,
                             @RequestParam("fileId") String fileId,
                             @RequestParam("fileType") String fileType,
                             @RequestParam("filePid") String filePid){
        String token=(String)session.getAttribute("token");
        UserInfo userInfo = (UserInfo)redisTemplate.opsForValue().get(token);
        String userId=userInfo.getUserId();
        Boolean isDelete = fileInfoService.deleteOneFile(userId, fileId, fileType, filePid);
        if(isDelete){
            return Result.build(null,"删除成功",200);

        }else{
            return Result.build(null,"删除失败",201);
        }
    }

   // 文件上传
    @PostMapping("/uploadFile")
    public Result uploadFile(HttpSession session,
                             @RequestParam(required = false) String fileId,
                             MultipartFile file,
                             String fileName,
                             String filePid,
                             String fileMd5,
                             Integer chunkIndex,
                             Integer chunks){
        UserInfo userInfo=getUserInfo(session);
        UploadResultDto uploadResultDto = null;
        try {
            uploadResultDto = fileInfoService.uploadFile(userInfo, fileId, file, fileName, filePid, fileMd5, chunkIndex, chunks);
        } catch (GlobalException e) {
            return Result.build(null,e.getMessage(),201);
        }

        return Result.build(uploadResultDto,"发送成功",200);
    }
//获取当前目录
    @GetMapping("/getFolderInfo")
    public Result getFolderInfo(HttpSession session,String path,String fileName){
        UserInfo userInfo=getUserInfo(session);
        List folderInfos = fileInfoService.getFolderInfo(path, userInfo.getUserId());
        return Result.build(folderInfos,"查询成功",200);
    }
//    获取所有文件夹
    @GetMapping("/loadAllFolder")
    public Result loadAllFolder(HttpSession session, String filePid,@RequestParam(value = "currentFileIds",required = false) String currentFileIds){
        UserInfo userInfo=getUserInfo(session);
        LambdaQueryWrapper<FileInfo> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(FileInfo::getUserId,userInfo.getUserId());
        wrapper.eq(FileInfo::getFilePid,filePid);
        if(null!=currentFileIds){
            String[] split = currentFileIds.split(",");
            List<String> list = Arrays.stream(split).toList();
            wrapper.notIn(FileInfo::getFileId,list);
        }
        wrapper.eq(FileInfo::getFolderType, (byte)IsFolder.Y.getCode());
        wrapper.eq(FileInfo::getDelFlag,(byte) FileStatus.FILE_USE.getStatus());
        wrapper.orderByDesc(FileInfo::getCreateTime);
        List<FileInfo> list = fileInfoService.list(wrapper);
        return Result.build(list,"查询成功",200);
    }
//    移动文件
    @GetMapping("/changeFileFolder")
    public Result changeFileFolder(HttpSession session,String fileIds,String filePid)  {
        UserInfo userInfo = getUserInfo(session);
        try {
            fileInfoService.changeFileFolder(fileIds,filePid,userInfo.getUserId());
        } catch (GlobalException e) {
            Result.build(null,e.getMessage(),201);
        }
        return Result.build(null,"移动成功",200);
    }

//    根据token从redis中获取用户数据
    UserInfo getUserInfo(HttpSession session){
            String token=(String)session.getAttribute("token");
            UserInfo userInfo = (UserInfo)redisTemplate.opsForValue().get(token);
            return userInfo;
        }
}
