package com.example.Repository;

import com.example.model.entity.User;
import com.example.model.service.UserServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface UserRepository extends JpaRepository<User, String> {

   Optional<User> findByUsername(String username);
}
