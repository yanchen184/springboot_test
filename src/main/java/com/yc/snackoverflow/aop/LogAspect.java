package com.yc.snackoverflow.aop;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;

@Aspect
@Component
public class LogAspect {

    private final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Before("@within(logAopAnnotation)")
    public void logControllerUsage(JoinPoint joinPoint, LogAop logAopAnnotation) { // TODO
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String httpMethod = request.getMethod();
        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();
        String args = Arrays.toString(joinPoint.getArgs());

//        String logMessage = String.format("method [%s]. API: %s, Args: %s", httpMethod, methodName, args);
//        logger.info(logMessage);
    }
}

