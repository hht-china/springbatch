package com.example.demo.interceptor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSON;
import com.example.demo.pojo.SysLog;
import com.example.demo.util.LogUtil;

/**
 * 拦截自定义的MySysLog注解，进行特殊处理
 * 
 * @author hongtao.hao
 * @date 2019/6/27
 */
@Aspect
@Component
public class MySysLogAspect extends HandlerInterceptorAdapter {
    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    // @annotation 指定自定义注解：在自定义注解出现的位置切入代码
    @Pointcut("@annotation(com.example.demo.annotation.MySysLog)")
    public void logPointCut() {

    }

    @Before("logPointCut()")
    public void saveSysLog(JoinPoint joinPoint) {

    }

    @AfterReturning(returning = "result", pointcut = "logPointCut()")
    public void doAfterReturning(JoinPoint joinPoint, Object result) {

    }
}
