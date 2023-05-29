package com.example.caraz.manager;
import com.example.caraz.dto.CarDto;
import com.example.caraz.entity.Car;
import com.example.caraz.exception.NotFound;
import com.example.caraz.mapper.CarMapper;
import com.example.caraz.repository.CarRepository;
import com.example.caraz.service.Service;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@AllArgsConstructor
public class CarManager implements Service<CarDto> {

    private final CarRepository carRepository;
    private final CarMapper carMapper;
    @Override
    public void add(CarDto car) {
        carRepository.save(carMapper.toCarEntity(car));

    }
    @Override
    public CarDto getByID(Integer id) {
        return carRepository.findById(id)
                .stream().map(carMapper::toCarDto)
                .findFirst().orElseThrow(()-> new NotFound("Car not found!"));
    }

    @Override
    public List<CarDto> findAll(int page,int count) {
        Page<Car> all = carRepository.findAll(PageRequest.of(page,count));

        return all.getContent()
                .stream().map(carMapper::toCarDto)
                .toList();
    }

    @Override
    public void deleteByID(int id) {
        carRepository.deleteById(id);
    }
}
