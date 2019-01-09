package org.shop.aspects;

//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Aspect
@Configuration
//@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableAspectJAutoProxy
public class LoggingAspect {

    //private final static Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Pointcut("execution(* *(..)) && !within(is(EnumType)) && !within(is(FinalType))")
    public void loggedClass() { }


    //@Before("execution(* org.shop.*.*(..))")
    //@Before("execution(* *(..))")
    @Before("loggedClass()")
    public void before(JoinPoint joinPoint){
        //Advice
        //logger.info(" Check for user access ");
        logger.info(" Allowed execution for {}", joinPoint);
                System.out.println("AOP logging -> "
                + joinPoint.toLongString());
        String methodName = joinPoint.getSignature().getName();
        Object[] methodArgs = joinPoint.getArgs();
        logger.debug("Call method " + methodName + " with args " + methodArgs);

    }

//    @After("execution(* org.shop.*.*(..))")
//    public void after(JoinPoint joinPoint){
//        //Advice
//        logger.info(" Check for user access ");
//        logger.info(" Allowed execution for {}", joinPoint);
//        System.out.println("AOP logging -> "
//                + joinPoint.toShortString() );
//    }
//
//    @Around("execution(* org.shop.*.*(..))")
//    public void around(JoinPoint joinPoint){
//        //Advice
//        logger.info(" Check for user access ");
//        logger.info(" Allowed execution for {}", joinPoint);
//        System.out.println("AOP logging -> "
//                + joinPoint.toShortString() );
//    }

    //@Pointcut("@annotation(final)")
    //@Pointcut("@initialization(final)")
//    @Pointcut("@this(final *)")
//    public void finalClass() { }


//    @Pointcut("execution(* org.shop.*.*(..))")
//    public void webServiceMethod() {}
//
//    //@Pointcut("@annotation(exampl")
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
//
//    @After("execution(* org.shop.*(..))")
//    public void logMethodExecutionAfter(JoinPoint jp) {
//        System.out.println("AOP logging -> "
//                + jp.toShortString() );
//    }


}

