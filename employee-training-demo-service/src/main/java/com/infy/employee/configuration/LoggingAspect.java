package com.infy.employee.configuration;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Configuration
@EnableAspectJAutoProxy
public class LoggingAspect {

    @Before("execution(* com.infy.employee.controller.EmployeeController.*(..))")
    public void logging(JoinPoint joinPoint){
        System.out.println("BEFORE THE METHOD IS CALLED ITS IS BEING LOGGED THROUGH ASPECT PROGRAMMING");
    }
}
