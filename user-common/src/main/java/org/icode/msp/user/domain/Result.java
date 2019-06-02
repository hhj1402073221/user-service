package org.icode.msp.user.domain;

import lombok.Data;

/**
 * Created by sheriff on 2018/11/20.
 */
@Data
public class Result<T> {

    /** 错误码. */
    private Integer code;

    /** 提示信息. */
    private String msg;

    /** 具体的内容. */
    private T data;

}
