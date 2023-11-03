package com.example.yunpan.entity.Enums;

public enum FileResultStatus {
    UPLOAD_SECONDS("upload_seconds","秒传"),
    UPLOADING("uploading","上传中"),
    UPLOAD_FINISH("upload_finish","上传完成");
    private String code;
    private String desc;

    FileResultStatus(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
