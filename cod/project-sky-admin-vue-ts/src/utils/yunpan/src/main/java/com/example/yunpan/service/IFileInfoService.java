package com.example.yunpan.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.yunpan.entity.FileInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.yunpan.entity.Enums.FileType;
import com.example.yunpan.entity.UserInfo;
import com.example.yunpan.entity.dto.UploadResultDto;
import com.example.yunpan.util.GlobalException;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author baomidou
 * @since 2023-06-27
 */
public interface IFileInfoService extends IService<FileInfo> {

    Page getFileByCategory(String userId, int categoryId,Integer pageNo,Integer pageSize,String pid,String fileName);



    FileInfo getFile(String userId, String fileId, String filePid);

    void removeFile(String userId, String fileId, String filePid);

    Boolean deleteOneFile(String userId, String fileId, String fileType, String filePid);

    Boolean moveFileToRecycleBin(String userId, String fileId, String fileType, String filePid);
    UploadResultDto uploadFile(UserInfo userInfo,String fileId, MultipartFile file, String fileName, String filePid, String fileMd5, Integer chunkIndex, Integer chunks) throws GlobalException;
    Integer getUserSpace(String userId);

    FileInfo saveFolder(String folderName, String userId, String filePid);

    List getFolderInfo(String path, String userId);
    void changeFileFolder(String fileIds,String filePid,String userId) throws GlobalException;
}
