package com.example.caraz.dto;


import com.example.caraz.entity.Model;
import com.example.caraz.entity.MyUser;
import jakarta.validation.constraints.NotBlank;

public record CarDto(
        @NotBlank
        String color,
        Model model,
        Integer price,
        MyUser user
) {

}
