package com.flab.myeongu.example.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
@Slf4j
public class LogAspect {

    @Around("@annotation(com.flab.myeongu.example.annotation.LogExecutionTimeCheck)")
    public Object logExecutionTimeCheck(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("{}", joinPoint.getSignature());
        StopWatch stopWatch = new StopWatch("logExecutionTime");
        stopWatch.start();

        //Thread.sleep(1000);
        Object proceed = joinPoint.proceed();

        stopWatch.stop();
        log.info(stopWatch.prettyPrint());

        return proceed;
    }
}
