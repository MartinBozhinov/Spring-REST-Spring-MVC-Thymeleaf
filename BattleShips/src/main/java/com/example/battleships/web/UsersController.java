package com.example.battleships.web;

import com.example.battleships.Service.UserService;
import com.example.battleships.model.binding.UserLoginBindingModel;
import com.example.battleships.model.binding.UserRegisterBindingModel;
import com.example.battleships.model.service.UserServiceModel;
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
public class UsersController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UsersController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/login")
    public String login(@ModelAttribute("userLoginBindingModel") UserLoginBindingModel userLoginBindingModel) {
        return "login";
    }

    @PostMapping("/login")
    public String loginConfirm(@Valid @ModelAttribute("userLoginBindingModel")
                                       UserLoginBindingModel userLoginBindingModel,
                               BindingResult bindingResult,
                               HttpSession httpSession,
                               RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "redirect:login";
        }

        UserServiceModel user = this.userService.findByUserName(userLoginBindingModel.getUsername());

        if (user == null || !user.getPassword().equals(userLoginBindingModel.getPassword())){
         redirectAttributes.addFlashAttribute("notFound", true);

         return "redirect:login";
        }

        httpSession.setAttribute("user", user);

        return "redirect:/";

    }


    @GetMapping("/register")
    public String register(@ModelAttribute("userRegisterBindingModel") UserRegisterBindingModel userRegisterBindingModel) {
        return "register";
    }


    @PostMapping("/register")
    public String registerConfirm(@Valid @ModelAttribute
            ("userRegisterBindingModel") UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() ||
                !userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {
            return "redirect:register";
        }
        this.userService.add(this.modelMapper.map(userRegisterBindingModel, UserServiceModel.class));
        return "redirect:login";
    }
}
