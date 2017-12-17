package com.b4u.tinyfacebook.aspectj;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author: hzy
 * @since:
 */
@Aspect
public class AudienceV2 {
    @Pointcut("execution(* com.b4u.tinyfacebook.aspectj.Performance(..))")
    public void performance() {
    }

    @Before("performance()")
    public void silenceCellPhone() {
        System.out.println("Silencing cell phone");
    }

    @Before("performance()")
    public void takeSeats() {
        System.out.println("Taking seats");
    }

    @AfterReturning("performance()")
    public void applause() {
        System.out.println("CLAP CLAP CLAP!!!");
    }

    @AfterReturning("performance()")
    public void demandRefund() {
        System.out.println("Demanding a refund");
    }
}
