package com.example.school.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * Created by Janak on 14-05-2020.
 */
@Aspect
@Component
public class LoggingAspectMarks {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspectMarks.class);
    //private static final Logger LOGGER1 = LoggerFactory.getLogger(LoggingAspectStudent.class);
    @Around("execution(* com.example.school.controller.UniversityController.*(..))")
    public Object profileMarksMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();
        final StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result = proceedingJoinPoint.proceed();
        stopWatch.stop();
        //execTime = execTime + stopWatch.getTotalTimeMillis();
        LOGGER.info("Execution time of " + className + "." + methodName + " "
                + ":: " + stopWatch.getTotalTimeMillis() + " ms" );
        /*LOGGER1.info("Execution time of " + className + "." + methodName + " "
                + ":: " + stopWatch.getTotalTimeMillis() + " ms" );*/
        return result;
    }

}
