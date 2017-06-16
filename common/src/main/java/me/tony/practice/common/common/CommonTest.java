package me.tony.practice.common.common;

import me.tony.practice.common.Base;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;


/**
 * Created by tony on 2017/2/15.
 */
public class CommonTest extends Base {

    @Test
    public void testArray() {
        logger.info("{}, {}, {}, {}, {}", A.class.isAssignableFrom(A.class), A.class.isAssignableFrom(B.class), A.class.isAssignableFrom(C.class), C.class.isAssignableFrom(A.class), A.class.isAssignableFrom(D.class));
    }

    @Test
    public void testClassInstance() {
        Class ac = A.class;
        Class ac2 = A.class;
        A a = new A();
        Class ac3 = a.getClass();
        logger.info("{} {} {}", ac == ac2, ac == ac3, ac2 == ac3);
    }

    @Test
    public void testIntegerEquals() {
        Integer i1 = new Integer(1);
        Integer i2 = new Integer(1);
        System.out.println(i1 == i2);
    }

    @Test
    public void testEquals() {
        A a = new A();
        System.out.println(Objects.equals(a.integer, 1));
    }

    @Test
    public void testChongfu() {
        List<String> strings = Arrays.asList("abc", "abc", "abcd", "bcde", "bd", "bcde", "bcd");
        List<String> collect = strings.stream().collect(Collectors.toMap(a -> a, a -> 1, (a, b) -> a + b))
                .entrySet().stream().filter(e -> e.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    static class A {
        Integer integer = null;

    }

    static class B extends A {

    }

    static class C extends B {

    }

    static class D {

    }
}
