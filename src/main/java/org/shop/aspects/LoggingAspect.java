package org.shop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoggingAspect {

//    private final static Logger LOG = LoggerFactory.getLogger(LoggingAspect.class);
//
//    @Pointcut("execution(* org.shop.*(..))")
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
//    @Before("execution(* org.shop.*(..))")
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
//

}
