package com.cs544.videorating.videoservice.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;


@Component
@Aspect
public class VideoAspect {
    @Autowired
    private static final Logger logger = LoggerFactory.getLogger(VideoAspect.class);

    @Before("execution(* com.cs544.videorating.videoservice.service.*.*(..))")
    public void logBeforeAllDaoMethods(JoinPoint jp){
        this.logger.info("the following Video endpoint is hit - " + jp.getSignature().getName());
    }

    @Around("execution(* getUserRatingByIdWith*(..))")
    public Object measureInterprocessSystemCallOnVideoMS(ProceedingJoinPoint jp) throws Throwable{
        StopWatch stopWatch = new StopWatch();
        Object retVal = null;
        String methodName = jp.getSignature().getName();
        stopWatch.start();
        try {
            retVal = jp.proceed();
        }catch(Throwable e){
            // do nothing
        }
        stopWatch.stop();
        long totalTime = stopWatch.getLastTaskTimeMillis();

        this.logger.info("Time to execute " + methodName + " = " +totalTime);
        return retVal;
    }
}
