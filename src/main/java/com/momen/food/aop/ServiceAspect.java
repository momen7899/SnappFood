package com.momen.food.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ServiceAspect {
    @Before(value = "execution(* com.momen.food.*.*Service.*(..)) && args(id)")
    public void beforeAdvice(JoinPoint joinPoint, Long id) {
        String print = "Before method:" + joinPoint.getSignature() + "\n" + "Get with  id - " + id;
        System.out.println(print);
        log.info(print);
    }

    @After(value = "execution(* com.momen.food.*.*Service.*(..)) && args(id)")
    public void afterAdvice(JoinPoint joinPoint, Long id) {
        String print = "After method:" + joinPoint.getSignature() + "\n" + "Get with  id - " + id;
        System.out.println(print);
        log.info(print);
    }
}
