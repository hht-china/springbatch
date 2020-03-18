package com.example.demo.exception;


import com.example.demo.common.Msg;

/**
 * @author hongtao.hao
 * @date 2019/6/27
 */
public class ServiceException extends BusinessException {

    private Msg msg;

    private Object data;

    public ServiceException(Msg msg) {
        super(msg.getTip());
        this.msg = msg;
    }

    public ServiceException(Msg msg, Object data) {
        super(msg.getTip());
        this.msg = msg;
        this.data = data;
    }

    public ServiceException(Msg msg, Throwable cause) {
        super(msg.getTip(), cause);
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public Msg getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }
}
