package me.tony.practice.springboot.mvc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@RestController
public class DemoController {

    @RequestMapping("/test")
    public String test(@RequestParam(value = "testparam",required = false)String[] testParam, HttpServletRequest request) {
        request.getParameterMap();
        return Arrays.toString(testParam);
    }
}
