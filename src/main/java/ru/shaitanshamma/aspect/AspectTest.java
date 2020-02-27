package ru.shaitanshamma.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
@Aspect
public class AspectTest {
    private Logger logger = Logger.getLogger(AspectTest.class.getName());

//    @AfterReturning(pointcut = "execution(* ru.shaitanshamma.services.impl.RoleServiceImpl.*(..))", returning = "result")
//    public void logAfterReturning(JoinPoint joinPoint, Object result){
//        String methodName = joinPoint.getSignature().getName();
//        logger.info("method " + methodName + "return value: " + result.toString());
//    }
//    @Before("execution(* ru.shaitanshamma.controlers.*.*(..))")
//    public void before(JoinPoint joinPoint){
//        logger.info("Call of {} " + joinPoint.getSignature().getName());
//    }
//
//    @After("execution(* ru.shaitanshamma.services.impl.*.*(..))")
//    public void after(JoinPoint joinPoint){
//        logger.info("Call of {} " + joinPoint.getSignature().getName());
//    }
//
//    @Around("@annotation(ExecutionTime)")
//    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
//        long start = System.currentTimeMillis();
//        Object proceed = joinPoint.proceed();
//        long executionTime = System.currentTimeMillis() - start;
//        logger.log(Level.INFO, joinPoint.getSignature() + " выполнен за " + executionTime + "мс");
//        return proceed;
//    }

}
