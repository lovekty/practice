package me.tony.practice.guice.bean.impl;

import me.tony.practice.guice.bean.MyService;

public class MyServiceImpl implements MyService {
    @Override
    public String foo() {
        return "foo() call";
    }

    @Override
    public void bar() {
        System.out.println("bar() call");
    }
}
