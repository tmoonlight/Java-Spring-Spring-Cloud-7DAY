package com.cyyz.spt.platform.common.util;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/7/3.
 */
public class Util<T> {
    public static String toString(Object obj) {
        return obj!=null?obj.toString():null;
    }

    //对象转字符串
    public static String objToStr(Object obj) {
        return obj == null ? "" : String.valueOf(obj);
    }

    //对象转Integer
    public static Integer objToInteger(Object obj) {
        if (obj == null)
            return null;
        String str = Util.objToStr(obj);
        Pattern pattern = Pattern.compile("^[0-9]+$");
        boolean flagNum = pattern.matcher(str).matches();
        boolean flagMax = false;
        if (StringUtils.isNotBlank(str)){
            flagMax = new BigDecimal(Integer.MAX_VALUE).compareTo(new BigDecimal(str)) < 1;
        }
        return flagNum && flagMax ? Integer.parseInt(str) : null;
    }

    public static int toNumber(String obj) {
        try {
            return Integer.valueOf(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    //生成6位随机数
    public static int randomNum6(){
        return (int)((Math.random()*9+1)*100000);
    }

    public static <T> Set<T> listToHashSet(List<T> list){
        if (list == null){
            return new HashSet<>();
        }

        Set<T> set = new HashSet<>();
        for (T elem:list){
            set.add(elem);
        }
        return set;
    }
}
