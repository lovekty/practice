package me.tony.practice.mapstruct.mapper;

import me.tony.practice.mapstruct.domain.UserDO;
import me.tony.practice.mapstruct.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author tony.zhuby
 * @date 2018/1/9
 */

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.impl", uses = SuperMapper.class)
public interface UserMapper {

    @Mapping(target = "gender")
    UserDTO from(UserDO user);

}
