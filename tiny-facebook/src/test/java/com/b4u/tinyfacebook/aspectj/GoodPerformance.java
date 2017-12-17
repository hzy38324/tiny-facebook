package com.b4u.tinyfacebook.aspectj;

/**
 * @author: hzy
 * @since:
 */
public class GoodPerformance implements Performance {
    @Override
    public void perform() {
        System.out.println("Performance begin");
    }

    @Override
    public void perform(String performName) {
        System.out.println("Performance" + performName + " begin");
    }
}
