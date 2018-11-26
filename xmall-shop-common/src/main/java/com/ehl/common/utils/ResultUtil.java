package com.ehl.common.utils;

import com.ehl.common.bean.Result;

/**
 * @className:ResultUtil
 * @description:
 * @author: 王明飞 102365
 * @createtime: 2018/11/26 22:15
 */
public class ResultUtil<T> {
    Result<T> result;

    public ResultUtil()
    {
        result = new Result<>();
        result.setCode(200);
        result.setSuccess(true);
        result.setErrmessage("sucess");
    }
}
