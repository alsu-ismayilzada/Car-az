package com.example.caraz.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@Entity(name = "user")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String fullName;

    Integer age;

    String mail;

    String password;
    @Column(name="is_active")
    Boolean isActive;

    @Enumerated(EnumType.STRING)
    Role role;
}
