package me.tony.practice.common.proxy;

/**
 * Created by tony on 2017/6/5.
 */
public class MyServiceImpl implements MyService {
    @Override
    public String func1() {
        return "method func1";
    }

    @Override
    public String func2() {
        return "method func2";
    }
}
