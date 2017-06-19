package me.tony.practice.common.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by tony on 2017/6/5.
 */
public class MyServiceHandler implements InvocationHandler {

    private MyService proxy;

    public MyServiceHandler(MyService proxy) {
        this.proxy = proxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理执行");
        Object ret = method.invoke(this.proxy, args);
        System.out.println("代理执行结束");
        return ret;
    }
}
