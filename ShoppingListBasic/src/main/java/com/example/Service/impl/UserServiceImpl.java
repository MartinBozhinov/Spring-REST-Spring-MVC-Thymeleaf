package com.example.Service.impl;

import com.example.Repository.UserRepository;
import com.example.Service.UserService;
import com.example.model.entity.User;
import com.example.model.service.UserServiceModel;
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
}
