package com.aop;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志切面
 *
 * @author Liukx
 * @create 2017-12-14 11:21
 * @email liukx@elab-plus.com
 **/
public class LogAspect {

    public LogAspect(){
        System.out.println("加载==============logAspect");
    }

    Logger logger = LoggerFactory.getLogger(LogAspect.class);

    public void before(JoinPoint point) {
        logger.info("=============before==================");
        System.out.println("---------------before---------------");
    }

    public void after(JoinPoint point, Object retValue) {
        logger.info("=============after==================");
        System.out.println("---------------after---------------");
    }


}
