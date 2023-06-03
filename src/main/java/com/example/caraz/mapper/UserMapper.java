package com.example.caraz.mapper;
import com.example.caraz.dto.UserDto;
import com.example.caraz.entity.MyUser;
import com.example.caraz.security.MyUserDetails;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(MyUser user);
    MyUser toUserEntity(UserDto userDto);
    MyUserDetails toMyUserDetails(MyUser user);
}