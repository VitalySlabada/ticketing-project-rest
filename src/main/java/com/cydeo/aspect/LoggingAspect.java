package com.cydeo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.keycloak.adapters.springsecurity.account.SimpleKeycloakAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;



@Aspect
@Configuration
@Slf4j
public class LoggingAspect {

    //Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    private String getUserName(){
        Authentication authentication  = SecurityContextHolder.getContext().getAuthentication();
        SimpleKeycloakAccount details = (SimpleKeycloakAccount) authentication.getDetails();

        return  details.getKeycloakSecurityContext().getToken().getPreferredUsername();
    }

    @Pointcut("execution(* com.cydeo.controller.ProjectController.*(..)) || execution(* com.cydeo.controller.TaskController.*(..))")
    private void anyControllerOperation(){}

    @Before("anyControllerOperation()")
    public void anyBeforeControllerOperationAdvice(JoinPoint joinPoint) {
        String username = getUserName();
        log.info("Before () -> User : {} - Method: {} - Parameters: {}", username, joinPoint.getSignature().toShortString(), joinPoint.getArgs());
    }

    @AfterReturning(pointcut = "anyControllerOperation()", returning = "results")
    public void anyAfterControllerOperationAdvice(JoinPoint joinPoint, Object results) {
        String username = getUserName();
        log.info("AfterReturning  -> User : {} - Method : {} - Results: {}", username, joinPoint.getSignature().toShortString(), results.toString());
    }

    @AfterThrowing(pointcut = "anyControllerOperation()", throwing = "exception")
    public void anyAfterThrowingControllerOperationAdvice(JoinPoint joinPoint, RuntimeException exception) {
        String username = getUserName();
        log.info("AfterThrowing  -> User : {} - Method : {} - Exception: {}", username, joinPoint.getSignature().toShortString(), exception.getMessage());
    }

}
