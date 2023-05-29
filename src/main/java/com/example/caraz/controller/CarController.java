package com.example.caraz.controller;
import com.example.caraz.dto.CarDto;
import com.example.caraz.manager.CarManager;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarController {
    private final CarManager carManager;

    public CarController(CarManager carManager) {
        this.carManager = carManager;
    }

    @PostMapping("")
    public void add(CarDto car){
        carManager.add(car);
    }
    @GetMapping("/{id}")
    public CarDto getByID(@PathVariable int id){
        return carManager.getByID(id);
    }
    @GetMapping("")
    public List<CarDto> findAll(@RequestParam(value = "page") int page,@RequestParam(value = "count") int count){
        return carManager.findAll(page,count);
    }
    @DeleteMapping("{id}")
    public void deleteByID(@PathVariable int id){
        carManager.deleteByID(id);
    }
}
