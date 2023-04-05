package com.serviceops.ecommerce.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class MeasureExecutionTimeAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Around("@annotation(com.serviceops.ecommerce.annotation.MeasureExecutionTime)")
    public Object meassureTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object proceed = proceedingJoinPoint.proceed();
        stopWatch.stop();
        logger.info("Method [{}] is execution time [{}] ms",proceedingJoinPoint.getSignature().getName(),stopWatch.getTotalTimeMillis());
        return  proceed;
    }

}
