package com.cyyz.spt.platform.common.constant;

/**
 * Created by Administrator on 2018/4/12 0012.
 */
public class ServiceConstant {



    public static final int AUDIT_STATUS_NOT_FILING = 0;      //
    public static final int AUDIT_STATUS_AUDIT_NOT_PASS = 6;      //
    public static final int AUDIT_STATUS_FILING = 5;      //
    public static final int AUDIT_STATUS_RETRACT = 7;      //已撤回

    public static final int DELETE = 1;
    public static final int NOT_DELETE = 0;

    public static final Integer ORDER_SOURCE_SHOP = 1;      //1 代表来自门店，
    public static final Integer ORDER_SOURCE_BUSINESS_PLATFORM = 2;     //2 代表商务平台
    public static final Integer ORDER_SOURCE_POLICE = 3;     //分局

    public static final int APPLY_TYPE_APPLY = 1;   //  增刻印章业务
    public static final int APPLY_TYPE_DELIVER = 2;  // 印章交付业务
    public static final int APPLY_TYPE_CHANGE_UNIT = 3;  // 单位变更业务
    public static final int APPLY_TYPE_CANCEL_UNIT = 4;  // 单位注销业务
    public static final int APPLY_TYPE_EXCHANGE_UNIT = 5;  // 单位转区业务
    public static final int APPLY_TYPE_RECORD = 6;         // 补录业务
    public static final int APPLY_TYPE_REPORT_LOSED = 7;         // 缴销挂失业务
    public static final int APPLY_TYPE_POLICE_FILING = 8;       //现场备案
    public static final int APPLY_TYPE_FIRST_APPLY = 9;   //  初次刻章业务

    public static final String ORDER_UNIT_CHANGE_UPDATE_STATUS_NO = "0"; //更新标识

    public static final String ORDER_UNIT_CHANGE_UPDATE_STATUS_YES = "1"; //更新标识

    //作废状态
    public static final String SEAL_CANCEL_STATUS_CANCELLATION = "6";  //缴销
    public static final String SEAL_CANCEL_STATUS_LOSS = "7";  //缴销
    public static final String SEAL_CANCEL_STATUS_SCRAP = "5";  //缴销

    //印章状态
    public static final String SEAL_STATUS_APPLYED = "1";  //已审批
    public static final String SEAL_STATUS_UNDERTAKED = "2";  //已承接
    public static final String SEAL_STATUS_MAKED = "3";  //已制作
    public static final String SEAL_STATUS_DELIVERD = "4";  //已交付
    public static final String SEAL_STATUS_SCRAPED = "5";  //已报废
    public static final String SEAL_STATUS_CANCELED = "6";  //已缴销
    public static final String SEAL_STATUS_LOSSED = "7";  //已挂失

    // 印章类型
    public static final String SEAL_TYPE_LEGAL_MAN = "05";

    //单位状态
    public static final String UNIT_STATUS_NORMAL = "0";  //正常
    public static final String UNIT_STATUS_CANCELED = "1";  //已注销
    public static final String UNIT_STATUS_LOCKED = "2";  //已锁定
    public static final String UNIT_STATUS_DELETED = "9";  //已删除


    // 订单状态
    public static final int ORDER_STATUS_TS = 0;   // 暂存
    public static final int ORDER_STATUS_SUBMIT = 1;
    public static final int ORDER_STATUS_PENDING_PAY = 2;
    public static final int ORDER_STATUS_PAYED = 3;
    public static final int ORDER_STATUS_APPLY_DRAWERBACK = 4;  // 退款申请
    public static final int ORDER_STATUS_DRAWERBACKING= 5;   // 退款中
    public static final int ORDER_STATUS_DRAWERBACKED= 6;   // 已退款
    public static final int ORDER_STATUS_CLOSE= 7;   // 已关闭
    public static final int ORDER_STATUS_REJECT= 8;   // 已驳回
    public static final int ORDER_STATUS_CONFIRM= 9;   // 已确认
    public static final int ORDER_STATUS_PENDING_DELIVER= 10;   // 待取货
    public static final int ORDER_STATUS_DELIVERD= 11;   // 已交付
    public static final int ORDER_STATUS_REJECT_DRAWERBACKE= 12;   // 退款被驳回


    //订单号生成
    public static final String ORDER_NUM_TYPE_SHOP = "1"; //门店来源
    public static final String ORDER_NUM_TYPE_BUSINESS_PLATFORM="0"; //商务平台来源
    public static final String ORDER_NUM_TYPE_POLICE="2"; //分局

    // 门店类型
    public static final String SHOP_TYPE_COR = "0";      // 合作门店类型
    public static final String SHOP_TYPE_NORMAL = "1";  //  普通门店类型

    // 订单操作标识
    public static final String BUSINESS_OPERATE_AR  = "1";  // 显示接单拒单按钮
    public static final String BUSINESS_OPERATE_DELIVER  = "2";  // 显示交付按钮

    //短信模版Code
    public static final String API_SMS_01_CODE = "swpt135037283";   //待取货通知
    public static final String API_SMS_02_CODE = "";   //现场备案短信通知

    public static final String ENTERPRISE_STATE_LOG_OUT = "0";//注销
    public static final String ENTERPRISE_STATE_LOG_OPEN = "1";//装机营业
    public static final String ENTERPRISE_STATE_LOG_CLOSE = "2"; //装机停业

    // 抽查状态
    public static final int ORDER_CHECK_COMMIT = 2;  // 门店补充资料
    public static final int ORDER_CHECK_PASS = 5;   // 抽查通过
    public static final int ORDER_CHECK_NOPASS = 6;  // 抽查不通过

    // 订单生命周期表 类型
    public static final int ORDER_LIFECYCLE_ORDER_COMMIT  = 0;     // 订单提交
    public static final int ORDER_LIFECYCLE_ORDER_FILING  = 5;    // 备案成功
    public static final int ORDER_LIFECYCLE_ORDER_NOFILING  = 6;  // 审核不通过
    public static final int ORDER_LIFECYCLE_CHECK_COMIT = 7;     //门店再提交抽查数据
    public static final int ORDER_LIFECYCLE_CHECK_PASS = 8;      // 公安抽查审核通过
    public static final int ORDER_LIFECYCLE_CHECK_NOPASS = 9;    //公安抽查审核不通过
    public static final int ORDER_LIFECYCLE_RETRACT = 10;    //订单撤回
    // 用户类型
    public static final String USER_TYPE_POLICE_CITY = "5";

    //系统配置类型
    public static final String SYS_CONFIG_TYPE_CITY = "15"; //配置类型:城市单位上报
    public static final String SYS_CONFIG_TYPE_CITY_PERIOD = "16"; //配置类型:上报单位预警时间间隔
    public static final String SYS_CONFIG_MONITOR_SERVER_DOWN = "17"; //监控服务器宕机
    public static final String SYS_CONFIG_BOOT_SERVER_DOWN = "18"; //微服务宕机
    public static final String SYS_CONFIG_MISS = "19"; //服务配置有误
}
