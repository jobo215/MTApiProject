package com.company.mt.api.logger;

import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import org.apache.logging.log4j.Logger;

@Component
@Aspect
@EnableAspectJAutoProxy
@NoArgsConstructor
public class AspectLogger {

    Logger logger = LogManager.getLogger(this.getClass());

    @Pointcut("execution(* com.company.mt.api.controllers.*.*(..)) || execution(* com.company.mt.api.services.*.*(..))")
    public void aspectLoggerInit() {}

    @Around("aspectLoggerInit()")
    public Object aspectLogger(@NotNull ProceedingJoinPoint joinPoint) throws Throwable {
        String[] splitClassName = joinPoint.getSignature().getDeclaringType().toString().split("\\.");
        String methodFullName = splitClassName[splitClassName.length - 1] + '.'
                + joinPoint.getSignature().getName() + "()";
        logger.info("{} started!", methodFullName);
        Object methodReturnValue;
        try {
            methodReturnValue = joinPoint.proceed();
            logger.info("{} ended!", methodFullName);
        } catch (Exception e) {
            logger.error("{} has error. Exception: {}. Stack trace: {}", methodFullName, e.getClass(), e.getMessage(), e);
            throw e;
        }
        return methodReturnValue;
    }

}
