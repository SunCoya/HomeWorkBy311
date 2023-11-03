package com.example.yunpan.entity.Enums;

public enum Category {
    VIDEO(0),
    MUSIC(1),
    IMAGE(2),
    DOC(3),
    OTHERS(4);
    private int categoryCode;

    Category(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public int getCategoryCode() {
        return categoryCode;
    }
}
