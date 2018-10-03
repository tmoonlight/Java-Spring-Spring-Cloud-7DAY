package com.cyyz.spt.platform.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;

import java.util.List;


/**
 * @Title: JsonUtil
 * @Description: json工具类
 * @author zjh
 */
public class JsonUtil {
    static ValueFilter valueFilter = new ValueFilter() {

        @Override
        public Object process(Object object, String name, Object value) {
            if ("".equals(value))
                return null;
            return value;
        }
    };

    /**
     * 序列化对象
     * @param o
     * @return
     */
    public static String objectToJson(Object o) {
        try {
            return JSON.toJSONString(o);
        } catch (Exception e) {
            throw new RuntimeException("不能序列化对象为Json", e);
        }
    }

    /**
     * 序列化对象
     * @param o
     * @param type 日期格式化
     * @return
     */
    public static String objectToJson(Object o, DateFormatType type) {
        return objectToJson (o,type, SerializerFeature.DisableCircularReferenceDetect);
    }

    /**
     * 序列化对象
     * @param o
     * @param type
     * @param s
     * @return
     */
    public static String objectToJson(Object o, DateFormatType type, SerializerFeature s) {
        try {
            return  JSON.toJSONStringWithDateFormat(o,type.getValue(), s);
        } catch (Exception e) {
            throw new RuntimeException("不能序列化对象为Json", e);
        }
    }

    /**
     * 将 json 字段串转换为 对象.
     * @param json  字符串
     * @param clazz 需要转换为的类
     * @return
     */
    public static <T> T json2Object(String json, Class<T> clazz) {
        try {
            return JSON.parseObject(json, clazz);
        } catch (Exception e) {
            throw new RuntimeException("将 Json 转换为对象时异常,数据是:" + json, e);
        }
    }

    /**
     *  将 json 字段串转换为 集合
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> json2List(String json, Class<T> clazz){
        try {
            return JSON.parseArray(json,clazz);
        } catch (Exception e) {
            throw new RuntimeException("将 Json 转换为集合时异常,数据是:" + json, e);
        }
    }

    /**
     * 将json 中的 "" 转换为null
     * @param jsonObj
     * @return
     */
    public static JSONObject nullValueToNull(JSON jsonObj){

        String result = JSONObject.toJSONString(jsonObj,valueFilter);
        JSONObject obj = JSON.parseObject(result);

        return obj;
    }

    /**
     * 字符串是否为json格式
     * @param json
     * @return
     * @throws Exception
     */
    public static boolean isJson(String json) throws Exception{
        try {
            JSON.parseObject(json);
            return true;
        } catch (JSONException e) {
            return false;
        }
    }
}
