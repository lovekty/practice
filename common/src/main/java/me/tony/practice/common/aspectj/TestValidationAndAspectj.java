package me.tony.practice.common.aspectj;

import me.tony.practice.common.Base;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Created by tony on 2017/2/15.
 */
@ContextConfiguration({"classpath:spring.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestValidationAndAspectj extends Base {

    @Autowired
    NeedValidate needValidate;

    @Test
    public void test() {
        try {
            List<String> l1 = needValidate.test(Arrays.asList(1, 2, 3));
            System.out.println(l1.size());
            List<String> l2 = needValidate.test(Collections.emptyList());
            System.out.println(l2.size());
        } catch (Exception e) {
            if (e instanceof ConstraintViolationException) {
                ConstraintViolationException cve = (ConstraintViolationException) e;
                Set<ConstraintViolation<?>> violations = cve.getConstraintViolations();
                for (ConstraintViolation<?> c : violations) {
                    System.out.println(c.getMessage());
                }
            }
        }
    }

}
