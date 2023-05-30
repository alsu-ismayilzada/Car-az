package com.example.caraz.repository;
import com.example.caraz.dto.UserDto;
import com.example.caraz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findUserByMail(String mail);
}
