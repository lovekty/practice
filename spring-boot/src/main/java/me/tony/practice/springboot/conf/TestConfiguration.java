package me.tony.practice.springboot.conf;

import me.tony.practice.springboot.bean.BarBean;
import me.tony.practice.springboot.bean.FooBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tony.zhuby
 * @date 2017/12/18
 */
//@Configuration
public class TestConfiguration {

//    @Bean
    public static FooBean foo() {
        final FooBean foo = new FooBean();
        foo.setFoo("foo");
        return foo;
    }

//    @Bean
    public BarBean bar() {

        final BarBean bar = new BarBean();
        bar.setBar("bar");
        return bar;
    }

}
