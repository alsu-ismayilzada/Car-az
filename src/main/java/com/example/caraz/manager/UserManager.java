package com.example.caraz.manager;
import com.example.caraz.dto.RegisterRequest;
import com.example.caraz.dto.UserDto;
import com.example.caraz.entity.MyUser;
import com.example.caraz.exception.NotFound;
import com.example.caraz.mapper.UserMapper;
import com.example.caraz.repository.UserRepository;
import com.example.caraz.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@AllArgsConstructor
public class UserManager implements UserService {

 private final UserRepository userRepository;
 private final UserMapper userMapper;
 private final PasswordEncoder passwordEncoder;

    @Override
    public void add(UserDto user) {
        userRepository.save(userMapper.toUserEntity(user));
    }

    @Override
    public UserDto getByID(Integer id) {
        return userRepository.findById(id)
                .stream().map(userMapper::toUserDto)
                .findFirst().orElseThrow(()-> new NotFound("User not found!"));
    }

    @Override
    public List<UserDto> findAll(int page,int count) {

        Page<MyUser> all = userRepository.findAll(PageRequest.of(page,count));

        return all.getContent()
                .stream().map(userMapper::toUserDto)
                .toList();
    }

    @Override
    public void deleteByID(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public MyUser getUserByMail(String mail) {
        return userRepository.findUserByMail(mail)
                .orElseThrow(()-> new NotFound("User not found!"));
    }

    public void register(RegisterRequest registerRequest) {
        System.out.println(registerRequest);
        MyUser user = MyUser.builder()
                .mail(registerRequest.email())
                .password(passwordEncoder.encode(registerRequest.password()))
                .build();
        userRepository.save(user);
}
}
