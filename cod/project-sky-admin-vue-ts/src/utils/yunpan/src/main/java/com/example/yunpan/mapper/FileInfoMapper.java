package com.example.yunpan.mapper;

import com.example.yunpan.entity.FileInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author baomidou
 * @since 2023-06-27
 */

public interface FileInfoMapper extends BaseMapper<FileInfo> {
    public  Integer getUserSpace(String user_id);
    public List<FileInfo> getFolderInfo(@Param("user_id") String userId,List<String> pathArray,@Param("order") String order );
 }
