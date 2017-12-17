package com.b4u.tinyfacebook.aspectj;

/**
 * @author: hzy
 * @since:
 */
public class BadPerformance implements Performance {
    @Override
    public void perform() {
        throw new RuntimeException();
    }

    @Override
    public void perform(String performName) {
        throw new RuntimeException();
    }
}
