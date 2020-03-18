package com.example.demo.interceptor;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.core.MethodParameter;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.alibaba.fastjson.JSON;
import com.example.demo.common.Msg;
import com.example.demo.common.ReturnResult;
import com.example.demo.exception.ServiceException;

/**
 * 异常拦截处理器
 * 
 * @author hongtao.hao
 * @date 2019/6/27
 */
@RestControllerAdvice
public class RestExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 自定义异常
     */
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public String handleServiceException(ServiceException e) {
        printLog(e);
        return JSON.toJSONString(ReturnResult.createErrorReturn(e.getMsg()));
    }

    /**
     * 参数校验
     */
    //TODO 怎么只返回注解上的value
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public String handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        printLog(e);
        return JSON.toJSONString(ReturnResult.createErrorReturn(Msg.ParameterError.getCode(), e.getMessage()));
    }

    @ExceptionHandler(DuplicateKeyException.class)
    @ResponseBody
    public String handleDuplicateKeyException(DuplicateKeyException e) {
        printLog(e);
        return JSON.toJSONString(ReturnResult.createErrorReturn(Msg.DuplicateKeyError));
    }

     //shiro 权限
//     @ExceptionHandler(AuthorizationException.class)
//     @ResponseBody
//     public ReturnResult handleAuthorizationException(AuthorizationException e){
//     logger.error(e.getMessage(), e);
//     return ReturnResult.createSuccessReturn();
//
//     }

    /**
     * 运行时异常
     * 
     * @param e
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public String runtimeExceptionHandler(RuntimeException e) {
        printLog(e);
        return JSON.toJSONString(new ReturnResult<>(Msg.RuntimeException));
    }

    /**
     * 空指针异常
     * 
     * @param e
     * @return
     */
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public String nullPointerExceptionHandler(NullPointerException e) {
        printLog(e);
        return JSON.toJSONString(new ReturnResult<>(Msg.NullPointerException));
    }

    /**
     * 类型转换异常
     * 
     * @param e
     * @return
     */
    @ExceptionHandler(ClassCastException.class)
    @ResponseBody
    public String classCastExceptionHandler(ClassCastException e) {
        printLog(e);
        return JSON.toJSONString(new ReturnResult<>(Msg.ClassCastException));
    }

    /**
     * IO异常
     * 
     * @param e
     * @return
     */
    @ExceptionHandler(IOException.class)
    @ResponseBody
    public String iOExceptionHandler(IOException e) {
        printLog(e);
        return JSON.toJSONString(new ReturnResult<>(Msg.IoException));
    }

    /**
     * 未知方法异常
     * 
     * @param e
     * @return
     */
    @ExceptionHandler(NoSuchMethodException.class)
    @ResponseBody
    public String noSuchMethodExceptionHandler(NoSuchMethodException e) {
        printLog(e);
        return JSON.toJSONString(new ReturnResult<>(Msg.NoSuchMethodException));
    }

    /**
     * 数组越界异常
     * 
     * @param e
     * @return
     */
    @ExceptionHandler(IndexOutOfBoundsException.class)
    @ResponseBody
    public String indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException e) {
        printLog(e);
        return JSON.toJSONString(new ReturnResult<>(Msg.IndexOutOfBoundsException));
    }

    /**
     * 400错误
     * 
     * @param e
     * @return
     */
    @ExceptionHandler({HttpMessageNotReadableException.class})
    @ResponseBody
    public String requestNotReadable(HttpMessageNotReadableException e) {
        printLog(e);
        return JSON.toJSONString(new ReturnResult<>(Msg.RequestNotReadable));
    }

    /**
     * 400错误
     * 
     * @param e
     * @return
     */
    @ExceptionHandler({TypeMismatchException.class})
    @ResponseBody
    public String requestTypeMismatch(TypeMismatchException e) {
        printLog(e);
        return JSON.toJSONString(new ReturnResult<>(Msg.BadRequest));
    }

    /**
     * 400错误
     * 
     * @param e
     * @return
     */
    @ExceptionHandler({MissingServletRequestParameterException.class})
    @ResponseBody
    public String requestMissingServletRequest(MissingServletRequestParameterException e) {
        printLog(e);
        return JSON.toJSONString(new ReturnResult<>(Msg.BadRequest));
    }

    /**
     * 405错误
     * 
     * @return
     */
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    @ResponseBody
    public String request405() {
        return JSON.toJSONString(new ReturnResult<>(Msg.MethodNotAllowed));
    }

    /**
     * 406错误
     * 
     * @return
     */
    @ExceptionHandler({HttpMediaTypeNotAcceptableException.class})
    @ResponseBody
    public String request406() {
        return JSON.toJSONString(new ReturnResult<>(Msg.NotAcceptable));
    }

    /**
     * 500错误
     * 
     * @param e
     * @return
     */
    @ExceptionHandler({ConversionNotSupportedException.class, HttpMessageNotWritableException.class})
    @ResponseBody
    public String server500(RuntimeException e) {
        printLog(e);
        return JSON.toJSONString(new ReturnResult<>(Msg.Error));
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String handleException(Exception e) {
        printLog(e);
        return JSON.toJSONString(ReturnResult.createErrorReturn(Msg.Error));
    }

    /**
     * 异常信息打印日志
     *
     * @param e
     */
    private void printLog(Exception e) {

        logger.error("error >>> ", e);
    }

}
