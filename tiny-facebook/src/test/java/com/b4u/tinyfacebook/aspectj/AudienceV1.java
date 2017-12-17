package com.b4u.tinyfacebook.aspectj;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author: hzy
 * @since:
 */
@Aspect
public class AudienceV1 {
    @Before("execution(* com.b4u.tinyfacebook.aspectj.Performance(..))")
    public void silenceCellPhone() {
        System.out.println("Silencing cell phone");
    }

    @Before("execution(* com.b4u.tinyfacebook.aspectj.Performance(..))")
    public void takeSeats() {
        System.out.println("Taking seats");
    }

    @AfterReturning("execution(* com.b4u.tinyfacebook.aspectj.Performance(..))")
    public void applause() {
        System.out.println("CLAP CLAP CLAP!!!");
    }

    @AfterReturning("execution(* com.b4u.tinyfacebook.aspectj.Performance(..))")
    public void demandRefund() {
        System.out.println("Demanding a refund");
    }
}
