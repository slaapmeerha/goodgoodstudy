package com.imooc.luckymoney.enums;

/**
 * 通过枚举将code和msg一一对应起来，进行统一的维护，便于以后进行修改
 */
public enum ResultEnum {
    UNKONW_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功"),
    PRIMARY(100, "小于10元"),
    MIDDLE(101, "大于10元小于16元"),
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
