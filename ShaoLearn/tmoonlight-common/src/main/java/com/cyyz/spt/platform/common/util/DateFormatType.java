package com.cyyz.spt.platform.common.util;


/**
 * @Title: DateFormatType
 * @Description: 日期format类型
 * @author zjh
 */
public enum DateFormatType {
    MONTH("yyyy-MM"),
    DATE("yyyy-MM-dd"),
    DATE_S("yyyyMMdd"),
    DATE_MMdd("MMdd"),
    DATETIME("yyyy-MM-dd HH:mm:ss"),
    DATETIME_S("yyyyMMddHHmmss");

    private String value;

    private DateFormatType(String value){
        this.value=value;
    }

    public String getValue() {
        return this.value;
    }
}
