package org.icode.msp.user.config;

/**
 * Created by sheriff on 2018/11/20.
 */
public enum ResultEnum {
    UNKONW_ERROR(-1, "未知错误"),
    SUCCESS(200, "成功"),
    ERROR_NULL_ID(101, "失败-ID不能为空！"),

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


