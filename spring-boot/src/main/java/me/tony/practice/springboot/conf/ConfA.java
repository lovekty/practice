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
public class ConfA {

//    private final BarBean bar;
//
//    @Autowired
//    public ConfA(BarBean bar) {
//        this.bar = bar;
//    }

    @Bean
    public FooBean foo() {
        return new FooBean();
    }
}
