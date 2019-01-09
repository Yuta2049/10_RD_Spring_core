package org.shop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Aspect
@Configuration
//@EnableAspectJAutoProxy(proxyTargetClass = true)
//@EnableAspectJAutoProxy
public class LoggingAspect {

    //private final static Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
    private Logger logger = LoggerFactory.getLogger(this.getClass());


//    @Bean // the Aspect itself must also be a Bean
//    public LoggingAspect myAspect() {
//        return new LoggingAspect();
//    }

    //@Before("execution(* org.shop.*.*(..))")
    //@Before("execution(* org.shop.*.*(..))")
    @Before("execution(* *(..))")
    public void before(JoinPoint joinPoint){
        //Advice
        logger.info(" Check for user access ");
        logger.info(" Allowed execution for {}", joinPoint);
                System.out.println("AOP logging -> "
                + joinPoint.toShortString() );

    }

    //@After("execution(* org.shop.*.*(..))")
    public void after(JoinPoint joinPoint){
        //Advice
        logger.info(" Check for user access ");
        logger.info(" Allowed execution for {}", joinPoint);
        System.out.println("AOP logging -> "
                + joinPoint.toShortString() );
    }

    @Around("execution(* org.shop.*.*(..))")
    public void around(JoinPoint joinPoint){
        //Advice
        logger.info(" Check for user access ");
        logger.info(" Allowed execution for {}", joinPoint);
        System.out.println("AOP logging -> "
                + joinPoint.toShortString() );
    }

//    @Pointcut("execution(* org.shop.*.*(..))")
//    public void webServiceMethod() {}
//
//    //@Pointcut("@annotation(exampl")
//
//    @Around("webServiceMethod()")
//    public Object logWebServiceCall(ProceedingJoinPoint thisJointPoint) throws Throwable {
//
//        System.out.println("AOP logging -> "
//                + thisJointPoint.toShortString() );
//
//
//        String methodName = thisJointPoint.getSignature().getName();
//        Object[] methodArgs = thisJointPoint.getArgs();
//
//        LOG.debug("Call method " + methodName + " with args " + methodArgs);
//
//        Object result = thisJointPoint.proceed();
//
//        LOG.debug("Method " + methodName + " returns " + result);
//
//        return result;
//
//    }
//
//    //@Before("execution(* org.shop.Operation.*(..))")
//    @Before("execution(* org.shop.*.*(..))")
//    public void logMethodExecution(JoinPoint jp) {
//        System.out.println("AOP logging -> "
//                + jp.toShortString() );
//    }
//
//
//    @After("execution(* org.shop.*(..))")
//    public void logMethodExecutionAfter(JoinPoint jp) {
//        System.out.println("AOP logging -> "
//                + jp.toShortString() );
//    }


}

