package me.tony.practice.common.aspectj;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by tony on 2017/2/15.
 */
@Validated
public class NeedValidate {

    public List<String> test(@NotEmpty List<Integer> integers) {
        return integers.stream().map(String::valueOf).collect(Collectors.toList());
    }
}
