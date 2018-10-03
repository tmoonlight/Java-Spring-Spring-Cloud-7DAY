package com.cyyz.spt.platform.common.util;

import java.util.Random;

/**
 * 获取一段任意长度的随机字符串
 * Created by taohuiqi on 2017/10/25.
 */
public class RandomStringUtil {

    public static String INIT_BUFFER = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static String INIT_CODE_BUFFER = "0123456789";

    public static String getRandomString(int length) {
        StringBuffer buffer = new StringBuffer(INIT_BUFFER);
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        int range = buffer.length();
        for (int i = 0; i < length; i ++) {
            sb.append(buffer.charAt(random.nextInt(range)));
        }
        return sb.toString();
    }

    /**
     * length长度的验证码
     * @param length
     * @return
     */
    public static String getRandomCode(int length) {
        StringBuilder buffer = new StringBuilder(INIT_CODE_BUFFER);
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int range = buffer.length();
        for (int i = 0; i < length; i ++) {
            sb.append(buffer.charAt(random.nextInt(range)));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(getRandomCode(6));
        }

    }

}
