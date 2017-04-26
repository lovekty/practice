package me.tony.practice.validate.biz;

import me.tony.practice.validate.service.HelloService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by tony on 2017/4/26.
 */
@Component
public class HelloContainer implements ApplicationListener<ContextRefreshedEvent> {

    private Map<String, HelloService> serviceMap;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext ctx = event.getApplicationContext();
        serviceMap = ctx.getBeansOfType(HelloService.class);
    }

    public String sayHello(int type) { // 1 english 2 chinese
        switch (type) {
            case 1:
                return serviceMap.get("english").sayHello();
            case 2:
                return serviceMap.get("chinese").sayHello();
            default:
                return "Unknown language";
        }
    }
}
