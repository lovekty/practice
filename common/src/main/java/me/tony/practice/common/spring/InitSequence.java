package me.tony.practice.common.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class InitSequence implements ApplicationContextAware, InitializingBean, DisposableBean {

    public InitSequence() {
        System.out.println("InitSequence: constructor");
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("startuporder.xml");
        InitSequence bean = ctx.getBean(InitSequence.class);
        bean.method();
        ctx.destroy();
    }

    public void method() {
        System.out.println("InitSequence: invoke method");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitSequence: afterPropertiesSet");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("InitSequence: setApplicationContext");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("InitSequence: postConstruct");
    }

    public void initMethod() {
        System.out.println("InitSequence: initMethod");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("InitSequence: destroy");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("InitSequence: preDestroy");
    }

    public void close() {
        System.out.println("InitSequence: close");
    }
}
