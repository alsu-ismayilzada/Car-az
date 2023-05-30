package com.example.caraz.controller;
import com.example.caraz.dto.CarDto;
import com.example.caraz.manager.CarManager;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasRole('ADMIN')")
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
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteByID(@PathVariable int id){
        carManager.deleteByID(id);
    }
}
