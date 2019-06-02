package org.icode.msp.user.utils;

import org.icode.msp.user.config.ResultEnum;
import org.icode.msp.user.domain.Result;

/**
 * Created by sheriff on 2018/11/20.
 */
public class ResultUtil {
    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(200);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(Integer code, String msg, Object object) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(object);
        return result;
    }

    public static Result error(ResultEnum resultEnum, Object object) {
        return error(resultEnum.getCode(),resultEnum.getMsg(), object);
    }
}
