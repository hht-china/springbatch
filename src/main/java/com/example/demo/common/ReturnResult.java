package com.example.demo.common;

import lombok.Getter;

/**
 * AJAX接口返回数据格式
 *
 * @author chengzhenxing
 * @date 2019/3/2
 **/
public class ReturnResult<T> {

    @Getter
    private int code;
    @Getter
    private String msg;
    @Getter
    private T data;

    public ReturnResult(Msg msg) {
        code = msg.getCode();
        this.msg = msg.getTip();
    }

    public ReturnResult(Msg msg, T object) {
        code = msg.getCode();
        this.msg = msg.getTip();
        data = object;
    }

    public ReturnResult(int code, String message) {
        this.code = code;
        this.msg = message;
    }

    public ReturnResult(int code, String tip, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ReturnResult() {
    }

    public static  <T> ReturnResult<T> createSuccessReturn() {
        return createSuccessReturn(null);
    }

    public static  <T> ReturnResult<T> createSuccessReturn(T object) {
        return new ReturnResult<>(Msg.Success, object);
    }

    public static  <T> ReturnResult<T> createErrorReturn(Msg msg) {
        return new ReturnResult<>(msg);
    }
    public static  <T> ReturnResult<T> createErrorReturn(T object) {
        return new ReturnResult<>(Msg.Error,object);
    }
    public static  <T> ReturnResult<T> createErrorReturn(int code , String object) {
        return new ReturnResult<>(code,object);
    }
}
