package me.tony.practice.common.common;

import me.tony.practice.common.Base;
import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
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

    @Test
    public void testMod() {
        System.out.println(-3 % 4);
    }

    @Test
    public void testSubString() {
        String host = "http://staging.max.ad.xiaomi.srv/";
        System.out.println(host.substring(0, host.length() - 1));

        String str = "a";
        System.out.println(str.substring(0, str.length() - 1));

        String empty = "";
        System.out.println(empty.substring(0, empty.length() - 1));
    }

    @Test
    public void getTimestamp() {
        LocalDateTime start = LocalDateTime.of(2017, 8, 31, 15, 59, 59);
        LocalDateTime end = LocalDateTime.of(2017, 8, 31, 17, 0, 1);
        System.out.println(Date.from(start.atZone(ZoneId.systemDefault()).toInstant()).getTime());
        System.out.println(Date.from(end.atZone(ZoneId.systemDefault()).toInstant()).getTime());
    }

    @Test
    public void timestamp() {
        LocalDateTime now = LocalDateTime.now();
        long nowL = System.currentTimeMillis();
        Instant nowI = Instant.now();
        System.out.println(now.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        System.out.println(nowL);
        System.out.println(nowI.toEpochMilli());
    }

    @Test
    public void testHashCode() {
        Foo f1 = new Foo(1, "haha");
        Foo f2 = new Foo(1, "haha");
        System.out.println(f1.hashCode());
        System.out.println(f2.hashCode());
        System.out.println(System.identityHashCode(f1));
        System.out.println(System.identityHashCode(f2));
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

    static class Foo {
        int id;
        String name;

        public Foo(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Foo)) return false;
            Foo foo = (Foo) o;
            return id == foo.id &&
                    Objects.equals(name, foo.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    static class TestCons{

        String str;
        Integer index;
        Object obj;

        public TestCons() {
            this((String) null);
        }

        public TestCons(String str) {
            this.str = str;
        }

        public TestCons(Integer index) {
            this.index = index;
        }

        public TestCons(Object obj) {
            this.obj = obj;
        }
    }
}
