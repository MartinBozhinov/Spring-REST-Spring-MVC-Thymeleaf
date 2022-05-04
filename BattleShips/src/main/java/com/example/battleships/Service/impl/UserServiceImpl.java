package com.example.battleships.service.impl;

import com.example.battleships.service.UserService;
import com.example.battleships.model.entity.User;
import com.example.battleships.model.service.UserServiceModel;
import com.example.battleships.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserServiceModel add(UserServiceModel userServiceModel) {
        User user = this.modelMapper.map(userServiceModel,User.class);
        return this.modelMapper.map(this.userRepository.saveAndFlush(user),UserServiceModel.class);

    }

    @Override
    public UserServiceModel findByUserName(String username) {
        return this.userRepository.findByUsername(username)
                .map(user -> this.modelMapper.map(user,UserServiceModel.class))
                .orElse(null);
    }
}
