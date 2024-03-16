package com.sky.constant;

public class ShopStatusConstant {

    //存储店铺是否营业的状态到redis中的key值
    public static final String SHOP_STATUS_KEY = "SHOP_STATUS";

    //营业 status = 1
    public static final Integer SHOP_STATUS_OPEN = 1;

    //打烊 status = 0
    public static final Integer SHOP_STATUS_CLOSE = 0;

    //营业中
    public static final String SHOP_STATUS_OPENING_MES = "营业中";

    //打烊中
    public static final String SHOP_STATUS_CLOSING_MES = "打烊中";
}
