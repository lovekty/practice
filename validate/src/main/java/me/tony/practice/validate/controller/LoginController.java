package me.tony.practice.validate.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by tony on 2017/4/26.
 */
@Controller
public class LoginController {

    @RequestMapping(value = "login")
    public String mockLogin() {
        SecurityUtils.getSubject().login(new UsernamePasswordToken("tony", new char[0]));
        return "redirect:/hello";
    }
}
