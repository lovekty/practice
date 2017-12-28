package me.tony.practice.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author tony
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
public class App {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
        System.out.println(context.getApplicationName());
    }
}
