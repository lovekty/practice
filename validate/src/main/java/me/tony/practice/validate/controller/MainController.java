package me.tony.practice.validate.controller;

import me.tony.practice.validate.biz.HelloContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tony on 2017/4/26.
 */
@RestController
public class MainController {

    private final HelloContainer hc;

    @Autowired
    public MainController(HelloContainer hc) {
        this.hc = hc;
    }

    @RequestMapping("/hello")
    public String sayHello(@RequestParam int type) {
        return hc.sayHello(type);
    }

}
