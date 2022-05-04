package com.example.battleships.service;

import com.example.battleships.model.service.UserServiceModel;

public interface UserService {

    UserServiceModel add(UserServiceModel userServiceModel);

    UserServiceModel findByUserName(String username);

}
