package com.example.Service;

import com.example.model.binding.UserLoginBindingModel;
import com.example.model.service.UserServiceModel;

public interface UserService {
    UserServiceModel add(UserServiceModel userServiceModel);

    UserServiceModel findByUsername(String username);

}
