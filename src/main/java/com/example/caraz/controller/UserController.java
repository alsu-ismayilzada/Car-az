package com.example.caraz.controller;
import com.example.caraz.dto.UserDto;
import com.example.caraz.manager.UserManager;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasRole('ADMIN')")
    public void add(UserDto user) {
        userManager.add(user);
    }

    @GetMapping("/{id}")
    public UserDto getByID(@PathVariable int id) {
        return userManager.getByID(id);
    }

    @GetMapping("")
    public List<UserDto> findAll(@RequestParam(value = "page") int page,@RequestParam(value = "count") int count) {
        return userManager.findAll(page,count);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteByID(@PathVariable int id) {
        userManager.deleteByID(id);
    }
}
