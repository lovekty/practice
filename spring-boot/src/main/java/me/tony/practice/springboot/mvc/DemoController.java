package me.tony.practice.springboot.mvc;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author tony
 */
@RestController
public class DemoController {

    @RequestMapping("/test")
    public String test(@RequestParam(value = "testparam", required = false) String[] testParam, HttpServletRequest request) {
        request.getParameterMap();
        return Arrays.toString(testParam);
    }

    @PostMapping("/post")
    public String post(HttpServletRequest request, @RequestBody Model data) {

        System.out.println("hello");
        System.out.println(data);


        return "done";
    }

    static class Model {
        String name;

        String mode;

        InnerModel inner;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMode() {
            return mode;
        }

        public void setMode(String mode) {
            this.mode = mode;
        }

        public InnerModel getInner() {
            return inner;
        }

        public void setInner(InnerModel inner) {
            this.inner = inner;
        }
    }

    static class InnerModel {
        String type;

        Integer level;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Integer getLevel() {
            return level;
        }

        public void setLevel(Integer level) {
            this.level = level;
        }
    }
}
