package com.example.caraz.service;

import com.example.caraz.dto.CarDto;
import com.example.caraz.entity.Car;

import java.util.List;

public interface CarService {
    void add(CarDto car);
    CarDto getByID(Integer id);
    List<CarDto> findAll(int page, int count);
    void deleteByID(int id);
}
