package me.tony.practice.validate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by tony on 2017/4/26.
 */
@SpringBootApplication(scanBasePackages = "me.tony.practice.validate")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
