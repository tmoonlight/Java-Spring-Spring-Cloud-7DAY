package com.cyyz.spt.platform.common.constant;

/**
 * Created by Administrator on 2018/7/11.
 * 财务相关常量类（主要用于中信电商管家）
 */
public class FinanceConstants {
    //支付订单交易类型 1
    private final String PAYMENT_ORDER_TRADE_TYPE_PAY  = "1";//支付
    private final String PAYMENT_ORDER_TRADE_TYPE_REJECTED  = "2";//退货 Rejected
    private final String PAYMENT_ORDER_TRADE_TYPE_OTHER  = " ";//其他

    //业务订单交易类型	362	2
    private final String BUSINESS_ORDER_TRADE_TYPE_PAY  = "1";//实时交易支付
    private final String BUSINESS_ORDER_TRADE_TYPE_REJECTED  = "2";//实时交易退货
    private final String BUSINESS_ORDER_TRADE_TYPE_PREPAY_PAY  = "3";//预付交易支付
    private final String BUSINESS_ORDER_TRADE_TYPE_PREPAY_CANCEL  = "4";//预付交易撤销
    private final String BUSINESS_ORDER_TRADE_TYPE_PREPAY_FINISH  = "5";//预付交易完成

    //清算资金来源	364	1
    private final String SOURCE_OF_LIQUIDATION_FUNDS_PAY_CHANNEL = "1";//支付渠道
    private final String SOURCE_OF_LIQUIDATION_FUNDS_INNER = "1";//内部划转

    //渠道手续费承担方式	365	1
    private final String WAYS_OF_HANDLING_CHANNEL_CHARGES_PLATFORM = "1";//平台商户承担
    private final String WAYS_OF_HANDLING_CHANNEL_CHARGES_MERCHANT = "2";//子商户承担
}
