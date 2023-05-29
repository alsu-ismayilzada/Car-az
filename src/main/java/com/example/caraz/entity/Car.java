package com.example.caraz.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Entity(name = "car")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String color;


    Integer model;

    int price;
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL)
    User user;

}
