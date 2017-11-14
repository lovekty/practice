package me.tony.practice.spring;

import me.tony.practice.spring.event.MyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        MyEvent event = new MyEvent();
        event.setContent("Hello world");
        event.setFlag(false);
        context.publishEvent(event);
    }
}
