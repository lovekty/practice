package me.tony.practice.springboot.conf;

import me.tony.practice.springboot.bean.BarBean;
import me.tony.practice.springboot.bean.FooBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tony.zhuby
 * @date 2017/12/27
 */
@Configuration
public class ConfB {

    private final FooBean foo;

    @Autowired
    public ConfB(FooBean foo) {
        this.foo = foo;
    }

    @Bean
    public BarBean bar() {
        return new BarBean();
    }
}
