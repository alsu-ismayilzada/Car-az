package com.example.caraz.manager;
import com.example.caraz.dto.UserDto;
import com.example.caraz.mapper.UserMapper;
import com.example.caraz.repository.UserRepository;
import com.example.caraz.service.Service;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@AllArgsConstructor
public class UserManager implements Service<UserDto> {

 private final UserRepository userRepository;
 private final UserMapper userMapper;
    @Override
    public void add(UserDto user) {
        userRepository.save(userMapper.toUserEntity(user));
    }

    @Override
    public UserDto getByID(Integer id) {
        return userRepository.findById(id)
                .stream().map(userMapper::toUserDto)
                .findFirst().get();
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll()
                .stream().map(userMapper::toUserDto)
                .toList();
    }

    @Override
    public void deleteByID(int id) {
        userRepository.deleteById(id);
    }
}
