package com.example.caraz.repository;
import com.example.caraz.dto.UserDto;
import com.example.caraz.entity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<MyUser, Integer> {

    Optional<MyUser> findUserByMail(String mail);
}
