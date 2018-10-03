package com.cyyz.spt.platform.common.request;

import java.util.Map;

/**
 * Created by wjh on 2018/4/11.
 */
public class Request {
    private Map<String,Object> params;

    private Map<String,Object> orders;

    public Map<String, Object> getParams() {
        return params;
    }


    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public Map<String, Object> getOrders() {
        return orders;
    }

    public void setOrders(Map<String, Object> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Request{" +
                "params=" + params +
                '}';
    }
}
