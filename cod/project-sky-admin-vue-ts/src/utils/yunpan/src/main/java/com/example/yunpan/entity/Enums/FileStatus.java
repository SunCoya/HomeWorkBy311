package com.example.yunpan.entity.Enums;

public enum FileStatus {
    FILE_USE(0),
    FILE_RECOVER(1),
    FILE_DELETE(2);
    private int status;

    FileStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
