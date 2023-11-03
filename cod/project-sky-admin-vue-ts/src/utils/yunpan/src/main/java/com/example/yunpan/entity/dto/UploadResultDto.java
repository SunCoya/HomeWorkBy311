package com.example.yunpan.entity.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class UploadResultDto implements Serializable {
    private String fileId;
    private String status;

}
