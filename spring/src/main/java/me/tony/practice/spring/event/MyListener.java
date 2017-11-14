package me.tony.practice.spring.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyListener {

    @EventListener(MyEvent.class)
    public void listen(MyEvent event) {
        System.out.println("listen " + event.getContent());
    }

    @EventListener(value = MyEvent.class, condition = "#event.flag")
    public void listen2(MyEvent event) {
        System.out.println("listen2 " + event.getContent());
    }

    @EventListener(Object.class)
    public void listenObject(Object event) {
        if (event instanceof MyEvent) {
            System.out.println("listen object " + ((MyEvent) event).getContent());
        } else {
            System.out.println("listen object " + event);
        }
    }
}
