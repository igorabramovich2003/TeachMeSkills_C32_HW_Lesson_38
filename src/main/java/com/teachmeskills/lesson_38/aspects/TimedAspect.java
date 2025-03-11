package com.teachmeskills.lesson_38.aspects;

import com.teachmeskills.lesson_38.annotations.Timed;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
@Component
public class TimedAspect {
    private static final Logger logger = LoggerFactory.getLogger(TimedAspect.class);

    @Around("@annotation(timed)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint, Timed timed) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - startTime;
        if (executionTime > 1000){
            logger.warn("Method {} completed in {} milliseconds.", joinPoint.getSignature().getName(), executionTime);
        }else {
            logger.info("Method {} completed in {} milliseconds.", joinPoint.getSignature().getName(), executionTime);
        }
        return proceed;
    }
}
