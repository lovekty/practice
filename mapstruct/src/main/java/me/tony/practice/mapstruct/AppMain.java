package me.tony.practice.mapstruct;

import me.tony.practice.mapstruct.mapper.UserMapper;
import org.mapstruct.factory.Mappers;

/**
 * @author tony.zhuby
 * @date 2018/1/9
 */
public class AppMain {

    public static void main(String[] args) {
        UserMapper mapper = Mappers.getMapper(UserMapper.class);
//        mapper.from();
    }
}
