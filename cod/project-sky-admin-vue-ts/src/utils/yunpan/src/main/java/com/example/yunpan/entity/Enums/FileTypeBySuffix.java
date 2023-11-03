package com.example.yunpan.entity.Enums;

import org.apache.commons.lang3.ArrayUtils;

import java.io.File;

public enum FileTypeBySuffix {
    VIDEO(Category.VIDEO,1,new String[]{".mp4",".avi",".rmvb",".mkv",".mov"},"视频"),
    MUSIC(Category.MUSIC,2,new String[]{".mp3",".wav",".wma",".mp2",".flac",".midi",".ra",".ape",".aac",".cda"},"音频"),
    IMAGE(Category.IMAGE,3,new String[]{".jpeg",".jpg",".png",".gif",".bmp",".dds",".psd",".pdt",".webp",".xmp",".svg",".tiff"},"图片"),
    PDF(Category.DOC,4,new String[]{".pdf"},"pdf"),
    WORD(Category.DOC,5,new String[]{".docx"},"word"),
    EXCEL(Category.DOC,6,new String[]{".xlsx"},"excel"),
    TXT(Category.DOC,7,new String[]{".txt"},"txt文本"),
    PROGRAME(Category.OTHERS,8,new String[]{".h",".c",".hpp",".hxx",".cpp",".cc",".c++",".cxx",".m",".o",".s",".dll",".cs",".java",".class",
    ".js",".ts",".css",".scss",".vue",".jsx",".sql",".md",".json",".html",".xml"},"CODE"),
    ZIP(Category.OTHERS,9,new String[]{".rar",".zip",".7z",".cab",".arj",".lzh",".tar",".gz",".ace",".uue",".bz",".jar",".iso",".mpg"},"压缩包"),
    OTHERS(Category.OTHERS,10,new String[]{},"其他");
    private Category category;
    private Integer type;
    private String[] suffixs;
    private String desc;

    FileTypeBySuffix(Category category, Integer type, String[] suffixs, String desc) {
        this.category = category;
        this.type = type;
        this.suffixs = suffixs;
        this.desc = desc;
    }
    public static FileTypeBySuffix getFileBySuffix(String suffix){
        for (FileTypeBySuffix item:FileTypeBySuffix.values()) {
            if(ArrayUtils.contains(item.getSuffixs(),suffix)){
                return item;
            }
        }
        return null;
    }
    public static FileTypeBySuffix getByType(Integer type){
        for (FileTypeBySuffix item:FileTypeBySuffix.values()) {
            if(item.getType().equals(type)){
                return item;
            }
        }
        return null;
    }

    public Category getCategory() {
        return category;
    }

    public Integer getType() {
        return type;
    }

    public String[] getSuffixs() {
        return suffixs;
    }

    public String getDesc() {
        return desc;
    }
}
