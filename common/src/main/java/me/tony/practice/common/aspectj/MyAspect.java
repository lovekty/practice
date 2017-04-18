package me.tony.practice.common.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by tony on 2017/2/15.
 */
@Aspect
public class MyAspect {

    @Pointcut("execution(* me.tony.practice.common.aspectj.NeedValidate.*(..)) && @args(ListNotEmpty)")
    private void aspect() {

    }

    @Around(value = "aspect()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        try {
            Object[] args = pjp.getArgs();
            MethodSignature ms = (MethodSignature) pjp.getSignature();
            Annotation[][] parameterAnnotations = ms.getMethod().getParameterAnnotations();
            for (int i = 0; i < args.length; i++) {
                Object arg = args[i];
                Annotation[] annotations = parameterAnnotations[i];
                for (Annotation anno : annotations) {
                    if (anno.annotationType().equals(ListNotEmpty.class)) {
                        if (arg instanceof Collection) {
                            if (((Collection) arg).isEmpty()) {
                                return Collections.emptyList();
                            }
                        }
                    }
                }
            }
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return pjp.proceed();

    }
}
