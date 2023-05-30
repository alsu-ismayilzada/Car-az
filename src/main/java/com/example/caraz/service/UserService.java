package com.example.caraz.service;

import com.example.caraz.dto.UserDto;
import com.example.caraz.entity.User;

import java.util.List;

public interface UserService {
    void add(UserDto user);
    UserDto getByID(Integer id);
    List<UserDto> findAll(int page, int count);
    void deleteByID(int id);
    User getUserByMail(String mail);
}
