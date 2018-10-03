package com.cyyz.spt.platform.common.constant;

/**
 * Created by admin on 2017/6/26.
 */
public abstract class HttpHeader {

    public static final String USER_TOKEN = "token";
    public static final String USER_ID = "userId";
    public static final String USER_TYPE = "userType";
    public static final String USER_NAME= "userName";
    public static final String DEP_ID = "depId";
    public static final String DEP_NAME = "depName";
    public static final String PRODUCTION_UNIT_ID = "productionUnitId";
    public static final String PRODUCTION_UNIT_NAME = "productionUnitName";
    public static final String PRODUCTION_TAG = "productionTag";
    public static final String AREA_CODE = "areaCode";
    public static final String APPROVE_CODE = "approveCode";
    public static final String IS_CYYZ = "isCyyz";
    public static final String AUTO_APPLY = "autoApply";
    public static final String ESEAL_APPLY = "eSealApply";
    public static final String COOPERATION_MODE = "cooperationMode";//外部企业核准模式   0：不扣费，1：扣费
    public static final String ROLE_ID = "roleId";
    public static final String CHECK_TYPE = "checkType"; //门店是否自动核查标识:1-是,0-否
    public static final String ALL_CITY = "allCity"; //是否全市统备案
}
