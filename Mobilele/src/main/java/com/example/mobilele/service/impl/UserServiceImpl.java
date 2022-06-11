package com.example.mobilele.service.impl;

import com.example.mobilele.entity.dto.UserLoginDTO;
import com.example.mobilele.entity.dto.UserRegisterDTO;
import com.example.mobilele.entity.model.UserEntity;
import com.example.mobilele.repository.UserRepository;
import com.example.mobilele.user.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl {

    private Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    private UserRepository userRepository;
    private CurrentUser currentUser;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           CurrentUser currentUser,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerAndLogin(UserRegisterDTO userRegisterDTO) {
        UserEntity newUser =
                new UserEntity().
                        setActive(true).
                        setEmail(userRegisterDTO.getEmail()).
                        setFirstName(userRegisterDTO.getFirstName()).
                        setLastName(userRegisterDTO.getLastName()).
                        setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));

        newUser = userRepository.save(newUser);

        login(newUser);
    }

    public boolean login(UserLoginDTO loginDTO) {
        Optional<UserEntity> userOpt = userRepository.
                findByEmail(loginDTO.getUsername());

        if (userOpt.isEmpty()) {
            LOGGER.info("User with not found. User name: {}",
                    loginDTO.getUsername());
            return false;
        }

        String rawPassword = loginDTO.getPassword();
        String encodedPassword = userOpt.get().getPassword();

        boolean success = passwordEncoder.
                matches(rawPassword, encodedPassword);

        if (success) {
            login(userOpt.get());
        } else {
            logout();
        }

        return success;
    }

    public void login(UserEntity userEntity) {
        currentUser.
                setLoggedIn(true).
                setName(userEntity.getFirstName() + " " + userEntity.getLastName());
    }

    public void logout() {
        currentUser.clear();
    }
}
