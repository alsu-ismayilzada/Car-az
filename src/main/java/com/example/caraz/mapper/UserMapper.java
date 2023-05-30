package com.example.caraz.mapper;
import com.example.caraz.dto.UserDto;
import com.example.caraz.entity.User;
import com.example.caraz.security.MyUserDetails;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);
    User toUserEntity(UserDto userDto);
    MyUserDetails toMyUserDetails(User user);
}