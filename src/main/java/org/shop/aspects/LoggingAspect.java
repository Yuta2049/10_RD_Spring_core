package org.shop.aspects;

import org.aspectj.lang.annotation.*;
import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Aspect
@Configuration
@EnableAspectJAutoProxy
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(* *(..)) && !within(is(EnumType)) && !within(is(FinalType))")
    public void loggedClass() { }

    @Before("loggedClass()")
    public void before(JoinPoint joinPoint){
        logger.info(" Allowed execution for {}", joinPoint);
    }
}

