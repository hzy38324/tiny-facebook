package com.b4u.tinyfacebook.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 计算某个节目的表演次数的切面
 *
 * @author: hzy
 * @since:
 */
@Aspect
public class PerformCountAspect {
    private Map<String, Integer> performCountMap = new ConcurrentHashMap<>();

    @Pointcut("execution(* com.b4u.tinyfacebook.aspectj.Performance.perform(String)) && args(performName)")
    public void performance(String performName) {
    }

    @Before("performance(performName)")
    public void addCount(String performName) {
        // Todo: 线程不安全
        int count = getPerformCount(performName);
        performCountMap.put(performName, count + 1);
    }

    public int getPerformCount(String performName) {
        return performCountMap.containsKey(performName) ? performCountMap.get(performName) : 0;
    }
}
