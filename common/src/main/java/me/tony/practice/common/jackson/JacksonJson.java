package me.tony.practice.common.jackson;

//import com.fasterxml.me.tony.practice.common.jackson.core.JsonFactory;

import me.tony.practice.common.Base;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * Created by tony on 2017/2/22.
 */
public class JacksonJson extends Base {
    @Test
    public void testStreamingApi() {
//        JsonFactory jsonFactory = new JsonFactory();
//        jsonFactory.createGenerator()
    }

    @Test
    public void testSet() {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = "{\"foo\":{\"list\":[1,2,3],\"set\":[1,2,3]}}";
        Bar foo;
        try {
             foo = objectMapper.readValue(jsonStr, Bar.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


class Foo {
    List<Integer> list;

    Set<Integer> set;

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    public Set<Integer> getSet() {
        return set;
    }

    public void setSet(Set<Integer> set) {
        this.set = set;
    }
}

class Bar {
    Foo foo;

    public Foo getFoo() {
        return foo;
    }

    public void setFoo(Foo foo) {
        this.foo = foo;
    }
}