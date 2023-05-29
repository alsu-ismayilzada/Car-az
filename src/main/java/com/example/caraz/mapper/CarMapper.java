package com.example.caraz.mapper;
import com.example.caraz.dto.CarDto;
import com.example.caraz.entity.Car;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarMapper {
    CarDto toCarDto(Car car);
    Car toCarEntity(CarDto carDto);
}
