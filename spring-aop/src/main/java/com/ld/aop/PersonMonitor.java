package com.ld.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class PersonMonitor {

    private static final Logger logger = LoggerFactory.getLogger(PersonMonitor.class);

//    @Before("execution(* com.ld.service.*.findPersonById(..))")
//    public void beforeFindById(JoinPoint joinPoint) {
//        String methodName = joinPoint.getSignature().getName();
//        logger.info("[beforeFindById]: ---> Method {} is about to be called", methodName);
//    }

    @Before("com.ld.util.PointcutContainer.repoFind()")
    public void beforeByPointCut(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("[beforeByPointCut]: ---> Method {} is about to be called", methodName);
    }


    @After("execution(* com.ld.service.*.findPersonById(..))")
    public void afterFindById(JoinPoint joinPoint) {
        String className = joinPoint.getClass().getName();
        logger.info("[afterFindById]: ---> Method {} is about to be called", className);
    }

//    @AfterReturning
//    @AfterThrowing (joinpoint, exception e)

    @Around("execution(* com.ld.service..*(..))")
    public Object aroundFind(ProceedingJoinPoint joinPoint) throws Throwable {
//        long startTime = System.currentTimeMillis();
//
//        joinPoint.proceed();
//
//        long timeTaken = System.currentTimeMillis() - startTime;
//        logger.info("Time Taken by {} is {}", joinPoint, timeTaken);
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        //Get intercepted method details
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();

        final StopWatch stopWatch = new StopWatch();

        //Measure method execution time
        stopWatch.start();
        Object result = joinPoint.proceed();
        stopWatch.stop();

        //Log method execution time
        logger.info("Execution time of " + className + "." + methodName + " "
                + ":: " + stopWatch.getTotalTimeMillis() + " ms");

        return result;

    }


}
