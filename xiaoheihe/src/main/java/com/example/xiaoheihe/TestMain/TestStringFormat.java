package com.example.xiaoheihe.TestMain;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;

import java.sql.SQLOutput;
import java.util.HashMap;

public class TestStringFormat {
    public static void main(String[] args) {
//        String str;
//        // %s
//        str = String.format("Hi,%s", "布鲁斯");
//        System.out.println(str);
//        // %c   %n
//        str = String.format("字母c的大写是：%c %n", 'C');
//        System.out.println(str);
//        // %b
//        str = String.format("布尔结果是：%b", 3>2);
//        System.out.println(str);
//        // %d
//        str = String.format("100的一半是：%d", 100/2);
//        System.out.println(str);
//        // %x
//        str = String.format("100的16进制数是：%x", 100);
//        System.out.println(str);
//        // %o
//        str = String.format("100的8进制数是：%o", 100);
//        System.out.println(str);
//        // %f
//        str = String.format("50元的书打8.5折扣是：%f 元", 50 * 0.85);
//        System.out.println(str);
//        // %a
//        str = String.format("上面价格的16进制数是：%a", 50 * 0.85);
//        System.out.println(str);
//        // %e
//        str = String.format("上面价格的指数表示：%e", 50 * 0.85);
//        System.out.println(str);
//        // %g
//        str = String.format("上面价格的指数和浮点数结果的长度较短的是：%g", 50 * 0.85);
//        System.out.println(str);
//        // %d%
//        str = String.format("上面的折扣是：%d%%", 85);
//        System.out.println(str);
//        // %h
//        str = String.format("字母A的散列码是：%h",'A');
//        System.out.println(str);
        String resp = "{\"replyCode\":\"000000\"," +
                "\"replyValue\":\"success\"}";

        BusinessTransResult businessTransResult = JSON.parseObject(resp, BusinessTransResult.class);
        if (businessTransResult.get(BusinessTransResult.CODE_TAG).toString().equalsIgnoreCase("000000")){
            System.out.println(businessTransResult.get(BusinessTransResult.DATA_TAG).toString());
        }

    }

}

class BusinessTransResult extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    /**
     * 状态码
     */
    public static final String CODE_TAG = "replyCode";


    /**
     * 数据对象
     */
    public static final String DATA_TAG = "replyValue";


    /**
     * 初始化一个新创建的 AjaxResult 对象，使其表示一个空消息。
     */
    public BusinessTransResult() {
    }

    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param code 状态码
     */
    public BusinessTransResult(String code) {
        super.put(CODE_TAG, code);
    }

    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param code 状态码
     * @param data 数据对象
     */
    public BusinessTransResult(String code, Object data) {
        super.put(CODE_TAG, code);
        super.put(DATA_TAG, data);
    }

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static BusinessTransResult success() {
        return BusinessTransResult.success("OK");
    }

    /**
     * 返回成功数据
     *
     * @return 成功消息
     */
    public static BusinessTransResult success(Object data) {
        return BusinessTransResult.success("OK", data);
    }

    private static BusinessTransResult success(String code, Object data) {
        return new BusinessTransResult(code, data);
    }


    /**
     * 返回错误消息
     *
     * @return
     */
    public static BusinessTransResult error() {
        return BusinessTransResult.error("ERROR");
    }

    /**
     * 返回错误消息
     *
     * @param data 错误信息
     * @return 警告消息
     */
    public static BusinessTransResult error(Object data) {
        return BusinessTransResult.error("ERROR", data);
    }

    /**
     * 返回错误消息
     *
     * @param code 错误信息
     * @param data 数据对象
     * @return 警告消息
     */
    public static BusinessTransResult error(String code, Object data) {
        return new BusinessTransResult(code, data);
    }

}
