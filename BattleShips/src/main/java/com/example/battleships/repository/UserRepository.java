package com.example.battleships.repository;

import com.example.battleships.model.entity.User;
import com.example.battleships.model.service.UserServiceModel;
import com.fasterxml.jackson.annotation.OptBoolean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    Optional<User> findByUsername(String username);
}
