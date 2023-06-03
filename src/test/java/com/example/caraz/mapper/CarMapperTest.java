package com.example.caraz.mapper;
import com.example.caraz.dto.CarDto;
import com.example.caraz.entity.Car;
import com.example.caraz.entity.MyUser;
import com.example.caraz.entity.Role;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarMapperTest {
    private final CarMapper carMapper = new CarMapperImpl();

    @Test
    void toCarDto() {
        //given
        Car car = new Car(1,"red",1,2000,new MyUser(1,"Alsu",20,"alsu.com","alsu",true, Role.USER));
        CarDto expected = new CarDto("red",1,2000,new MyUser(1,"Alsu",20,"alsu.com","alsu",true,Role.USER));
        //when
        CarDto actual = carMapper.toCarDto(car);
        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

   /* @Test
    void toCarEntity() {
        //given
        CarDto carDto = new CarDto("red",1,2000,new User(1,"Alsu",20,"alsu.com"));
        Car expected = new Car(1,"red",1,2000,new User(1,"Alsu",20,"alsu.com"));
        //when
        Car actual = carMapper.toCarEntity(carDto);
        //then
        Assertions.assertThat(actual).isEqualTo(expected);

    }*/
}