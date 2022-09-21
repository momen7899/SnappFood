package com.momen.food.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ExecutionAspect {

    @Around("@annotation(LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();
        String tag = "LogExecutionTime";
        long executionTime = System.currentTimeMillis() - start;
        String print = joinPoint.getSignature() + " executed in " + executionTime + "ms";
        System.out.println(print);
        log.info(tag, print);
        return proceed;
    }
}
