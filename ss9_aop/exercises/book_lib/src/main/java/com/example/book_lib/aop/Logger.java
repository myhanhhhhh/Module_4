package com.example.book_lib.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    private static int count;

    @After("execution(* com.example.book_lib.controller.BookController.*(..))")
    public void count() {
        count++;
        System.out.println("Number of access " + count);
    }

    @After("execution(* com.example.book_lib.controller.BookController.*(..))")
    public void writeLog(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName());
    }
}
