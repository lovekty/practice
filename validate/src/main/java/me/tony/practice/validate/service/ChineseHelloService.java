package me.tony.practice.validate.service;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Service;

/**
 * Created by tony on 2017/4/26.
 */
@Service("chinese")
public class ChineseHelloService implements HelloService {

    @Override
    @RequiresPermissions("chinese")
    public String sayHello() {
        return "你好";
    }
}
