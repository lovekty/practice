package me.tony.practice.common.common;

import me.tony.practice.common.Base;
import org.junit.Test;


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

    static class A {

    }

    static class B extends A {

    }

    static class C extends B {

    }

    static class D {

    }
}
