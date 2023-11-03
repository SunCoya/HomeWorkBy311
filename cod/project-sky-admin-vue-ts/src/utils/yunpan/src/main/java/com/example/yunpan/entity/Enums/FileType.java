package com.example.yunpan.entity.Enums;

public enum FileType {

                FOLDER(0),
                VIDEO(1),
                MUSIC(2),
                IMAGE(3),
                PDF(4),
                WORD(5),
                EXCEL(6),
                TXT(7),
                CODE(8),
                ZIP(9),
                OTHERS(10);

    public int getType() {
        return type;
    }
    public static FileType findEnumByCode(int code) {
        for (FileType statusEnum : FileType.values()) {
            if (statusEnum.getType()==code) {
                //如果需要直接返回name则更改返回类型为String,return statusEnum.name;
                return statusEnum;
            }
        }
        throw new IllegalArgumentException("code is invalid");
    }
    int type;

     FileType(int type) {
            this.type = type;
     }

}


