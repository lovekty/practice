package me.tony.practice.common.aspectj;

import java.lang.annotation.*;

/**
 * Created by tony on 2017/2/15.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@Documented
public @interface ListNotEmpty {
}
