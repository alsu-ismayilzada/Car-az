package com.example.caraz.security;
<<<<<<< HEAD
import com.example.caraz.mapper.UserMapper;
import com.example.caraz.service.UserService;
=======
>>>>>>> origin/db-connection
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final UserService userService;
    private final UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userMapper.toMyUserDetails(userService.getUserByMail(username));
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
