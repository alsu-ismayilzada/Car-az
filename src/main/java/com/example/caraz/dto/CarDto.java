package com.example.caraz.dto;


import com.example.caraz.entity.MyUser;

public record CarDto(
        String color,
        Integer model,
        Integer price,
        MyUser user
) {

}
