package com.ehl.common.bean;

import java.io.Serializable;

/**
 * @className:Result
 * @description:前后台交互标准格式
 * @author: 王明飞 102365
 * @createtime: 2018/11/26 21:43
 */
public class Result<T> implements Serializable {
    //返回代码
    private Integer code;

    //成功标志
    private boolean success;

    //响应消息
    private String message;

    //时间戳
    private long timestamp=System.currentTimeMillis();

    //结果对象
    private T result;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
