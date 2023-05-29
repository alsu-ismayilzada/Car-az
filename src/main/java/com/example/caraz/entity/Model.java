package com.example.caraz.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Entity(name = "model")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;
    @JoinColumn(name = "brand_id",referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL)
    Brand brand;
}
