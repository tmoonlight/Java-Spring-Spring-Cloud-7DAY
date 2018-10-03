package com.cyyz.spt.platform.common.util;

import com.alibaba.fastjson.JSON;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by jq.chen on 2017/6/3.
 * http请求工具类
 */
public class HttpClient {


    public static String postJson(String url, String json,int timeOutInMills){
        return postJson(url,null,json,timeOutInMills);
    }

    /**
     *
     * @param url
     * @param header
     * @param paramMap
     * @param timeOutInMills
     * @return
     */
    public static String postJson(String url, Map<String,String> header, Map<String,Object> paramMap, int timeOutInMills){
        String jsonParam = null;
        if(paramMap != null){
             jsonParam = JSON.toJSONString(paramMap);
        }
        return postJson(url,header,jsonParam,timeOutInMills);
    }

    /**
     * http post 请求
     *
     * @param url  请求地址
     * @param header 请求头
     * @param json 请求参数，json格式数据
     * @param timeOutInMills 请求超时时间，毫秒值
     * @return
     */
    public static String postJson(String url, Map<String,String> header, String json, int timeOutInMills) {
        CloseableHttpClient httpClient = HttpClients.createDefault();

         HttpPost httpPost = new HttpPost(url);
        if(timeOutInMills > 0) {
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(timeOutInMills).setConnectionRequestTimeout(timeOutInMills).build();
            httpPost.setConfig(requestConfig);
        }
        if(header != null){
            for(String headerKey:header.keySet()) {
                httpPost.setHeader(headerKey,header.get(headerKey));
            }
        }
        if (null != json) {
            StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
            entity.setContentEncoding("UTF-8");
            httpPost.setEntity(entity);
        }
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);
            return EntityUtils.toString(response.getEntity(), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            closeRes(response, httpClient);
        }
    }

    /***
     * Http PUT 请求
     * @param url
     * @param header
     * @param json
     * @param timeOutInMills
     * @return
     */
    public static String putJson(String url, Map<String,String> header, String json, int timeOutInMills) {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpPut httpPost = new HttpPut(url);
        if(timeOutInMills > 0) {
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(timeOutInMills).setConnectionRequestTimeout(timeOutInMills).build();
            httpPost.setConfig(requestConfig);
        }
        if(header != null){
            for(String headerKey:header.keySet()) {
                httpPost.setHeader(headerKey,header.get(headerKey));
            }
        }
        if (null != json) {
            StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
            entity.setContentEncoding("UTF-8");
            httpPost.setEntity(entity);
        }
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);
            return EntityUtils.toString(response.getEntity(), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            closeRes(response, httpClient);
        }
    }
    public static String putJson(String url, Map<String,String> header, Map<String,Object> paramMap, int timeOutInMills){
        String jsonParam = null;
        if(paramMap != null){
            jsonParam = JSON.toJSONString(paramMap);
        }
        return putJson(url,header,jsonParam,timeOutInMills);
    }

    public static String post(String url, Map<String,String> headers, Map<String,String> paramMap, int timeOutInMills) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost(url);
        try {
            if(timeOutInMills > 0) {
                RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(timeOutInMills).setConnectionRequestTimeout(timeOutInMills).build();
                httpPost.setConfig(requestConfig);
            }

            if(headers != null){
                Set<String> set = headers.keySet();
                Iterator<String> it = set.iterator();
                while(it.hasNext()){
                    String key = it.next();
                    httpPost.addHeader(key, headers.get(key));
                }
            }

            if(paramMap != null){
                List<NameValuePair> uvp = new LinkedList<NameValuePair>();
                Set<String> set = paramMap.keySet();
                Iterator<String> it = set.iterator();
                while(it.hasNext()){
                    String key = it.next();
                    uvp.add(new BasicNameValuePair(key,paramMap.get(key)));
                }
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(uvp,"UTF-8");
                httpPost.setEntity(entity);
            }

            CloseableHttpResponse response = null;

            response = httpClient.execute(httpPost);
            return EntityUtils.toString(response.getEntity(), "UTF-8");
        } finally {
            if(httpPost != null){
                httpPost.abort();
            }
        }
    }


    public static String get(String url){
        return get(url,null);
    }

    public static String get(String url,Map<String,String> headers){
        return get(url, headers,0);
    }
    /**
     * http get 请求
     *
     * @param url 请求地址
     * @return
     */
    public static String get(String url,Map<String,String> headers,int timeOutInMills) {
        CloseableHttpResponse response = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpGet httpGet = new HttpGet(url);

            if(timeOutInMills > 0) {
                RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(timeOutInMills).setConnectionRequestTimeout(timeOutInMills).build();
                httpGet.setConfig(requestConfig);
            }


            if(headers != null){
                Set<String> set = headers.keySet();
                Iterator<String> it = set.iterator();
                while(it.hasNext()){
                    String key = it.next();
                    httpGet.addHeader(key,  headers.get(key));
                }
            }

            response = httpClient.execute(httpGet);
            return EntityUtils.toString(response.getEntity(), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            closeRes(response, httpClient);
        }
    }

    public static Map<String,Object> getToIO(String url,Map<String,String> headers,int timeOutInMills) throws IOException {

        Map<String,Object> responseMap = new HashMap<>();
        CloseableHttpResponse response = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        ByteArrayOutputStream bos = null;
        try {
            HttpGet httpGet = new HttpGet(url);

            if(timeOutInMills > 0) {
                RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(timeOutInMills).setConnectionRequestTimeout(timeOutInMills).build();
                httpGet.setConfig(requestConfig);
            }


            if(headers != null){
                Set<String> set = headers.keySet();
                Iterator<String> it = set.iterator();
                while(it.hasNext()){
                    String key = it.next();
                    httpGet.addHeader(key,  headers.get(key));
                }
            }

            response = httpClient.execute(httpGet);

            InputStream is =  response.getEntity().getContent();

            bos = new ByteArrayOutputStream(response.getEntity().getContent().available());
            int buff_size=1024;
            byte[] bt = new byte[buff_size];
            int len;
            while( (len = is.read(bt,0,buff_size)) != -1){
                 bos.write(bt,0,len);
            }

            responseMap.put("byteArr",bos.toByteArray());
            responseMap.put("headers",response.getAllHeaders());
            responseMap.put("contentType",response.getEntity().getContentType().getValue());

            return responseMap;
        }finally {
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            closeRes(response, httpClient);
        }
    }

    private static void closeRes(CloseableHttpResponse response, CloseableHttpClient httpClient) {
        try {
            if (null != response) {
                response.close();
            }
            if (null != httpClient) {
                httpClient.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
