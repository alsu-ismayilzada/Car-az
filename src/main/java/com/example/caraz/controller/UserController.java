package com.example.caraz.controller;
import com.example.caraz.dto.UserDto;
import com.example.caraz.entity.User;
import com.example.caraz.manager.UserManager;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserManager userManager;

    public UserController(UserManager userManager) {
        this.userManager = userManager;
    }

    @PostMapping("")
    public void add(UserDto user) {
        userManager.add(user);
    }

    @GetMapping("/{id}")
    public UserDto getByID(@PathVariable int id) {
        return userManager.getByID(id);
    }

    @GetMapping("")
    public List<UserDto> findAll() {
        return userManager.findAll();
    }

    @DeleteMapping("{id}")
    public void deleteByID(@PathVariable int id) {
        userManager.deleteByID(id);
    }
}