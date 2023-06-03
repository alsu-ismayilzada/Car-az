package com.example.caraz.controller;
import com.example.caraz.dto.RegisterRequest;
import com.example.caraz.dto.UserDto;
import com.example.caraz.manager.UserManager;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserManager userManager;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserManager.class);

    public UserController(UserManager userManager) {
        this.userManager = userManager;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public void add(UserDto user) {
        userManager.add(user);
    }

    @GetMapping("/{id}")
    public UserDto getByID(@PathVariable int id) {
        return userManager.getByID(id);
    }

    @GetMapping
    public List<UserDto> findAll(@RequestParam(value = "page") int page,@RequestParam(value = "count") int count) {
        return userManager.findAll(page,count);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteByID(@PathVariable(name = "id") int id) {
        userManager.deleteByID(id);
    }

    @PostMapping("/register")
    public void register(@RequestBody RegisterRequest registerRequest){
        LOGGER.info("Register request accepted {}",registerRequest);
        userManager.register(registerRequest);
    }
}
