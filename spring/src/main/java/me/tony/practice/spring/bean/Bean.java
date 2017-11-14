package me.tony.practice.spring.bean;

public class Bean implements ISub {
    @Override
    public void bar() {
        System.out.println("bar");
    }

    @Override
    public void foo() {
        System.out.println("foo");
    }
}
