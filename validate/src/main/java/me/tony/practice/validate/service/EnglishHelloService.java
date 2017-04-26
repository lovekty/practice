package me.tony.practice.validate.service;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Service;

/**
 * Created by tony on 2017/4/26.
 */
@Service("english")
public class EnglishHelloService implements HelloService {
    @Override
    @RequiresPermissions("english")
    public String sayHello() {
        return "Hello";
    }
}
