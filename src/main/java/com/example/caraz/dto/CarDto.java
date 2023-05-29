package com.example.caraz.dto;

import com.example.caraz.entity.User;

public record CarDto(
        String color,
        Integer model,
        int price,
        User user
) {

}
