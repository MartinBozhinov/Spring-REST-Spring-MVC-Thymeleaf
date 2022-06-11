package com.example.mobilele.controller;

import com.example.mobilele.entity.dto.UserLoginDTO;
import com.example.mobilele.entity.dto.UserRegisterDTO;
import com.example.mobilele.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {


   private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(){
        return "auth-login";
    }

    @GetMapping("/logout")
    public String logout() {
        userService.logout();
        return "redirect:/";
    }

    @PostMapping("/login")
    public String loginConfirm(UserLoginDTO userLoginDTO){
     this.userService.login(userLoginDTO);
        return "redirect:/";
    }

    @ModelAttribute("userModel")
    public UserRegisterDTO initUserModel(){
        return new UserRegisterDTO();
    }

    @GetMapping("/register")
    public String register(){
        return "auth-register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegisterDTO userRegisterDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("userModel", userRegisterDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userModel", bindingResult);
            return "redirect:/users/register";
        }
        userService.registerAndLogin(userRegisterDTO);

        return "redirect:/";

    }




}
