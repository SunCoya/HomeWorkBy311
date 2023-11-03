package com.example.yunpan.entity.Enums;

public enum IsFolder {
    N(1),
    Y(0);
    private int code;

    public int getCode() {
        return code;
    }

    IsFolder(int code) {
        this.code = code;
    }
}
