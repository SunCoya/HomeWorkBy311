package com.example.yunpan.entity.Enums;

import lombok.Data;


public enum FileStoreStatus {
    TRANSFER(0,"转码中"),
    TRANSFER_FAIL(1,"转码失败"),
    USING(2,"使用中");

    private int status;
    private String desc;

    FileStoreStatus(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public int getStatus() {
        return status;
    }
}
