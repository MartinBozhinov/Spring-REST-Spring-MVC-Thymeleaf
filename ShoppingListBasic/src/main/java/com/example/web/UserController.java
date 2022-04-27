package com.example.web;

import com.example.Service.UserService;
import com.example.model.binding.UserLoginBindingModel;
import com.example.model.binding.UserRegisterBindingModel;
import com.example.model.service.UserServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginConfirm(@Valid @ModelAttribute
            ("userLoginBindingModel") UserLoginBindingModel userLoginBindingModel, BindingResult bindingResult
            , RedirectAttributes redirectAttributes, HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            return "redirect:login";
        }

        UserServiceModel user =  this.userService.findByUsername(userLoginBindingModel.getUsername());
        if (user == null || !user.getPassword().equals(userLoginBindingModel.getPassword())){
           redirectAttributes.addFlashAttribute("notFound",true);
           return "redirect:login";
        }
        httpSession.setAttribute("user", user);
        return "redirect:/";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid @ModelAttribute
            ("userRegisterBindingModel") UserRegisterBindingModel
                                          userRegisterBindingModel, BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() || !userRegisterBindingModel.getPassword()
                .equals(userRegisterBindingModel.getConfirmPassword())) {
            return "redirect:register";
        }
        this.userService.add(this.modelMapper.map(userRegisterBindingModel, UserServiceModel.class));
        return "redirect:login";

    }


}
