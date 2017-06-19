package me.tony.practice.common.proxy;

import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * Created by tony on 2017/6/5.
 */
public class ProxyTest {
    @Test
    public void testProxy() {
        MyServiceHandler handler = new MyServiceHandler(new MyServiceImpl());
        MyService service = (MyService) Proxy.newProxyInstance(MyService.class.getClassLoader(), new Class<?>[]{MyService.class}, handler);
        System.out.println(service.func1());
        System.out.println(service.func2());
    }
}
