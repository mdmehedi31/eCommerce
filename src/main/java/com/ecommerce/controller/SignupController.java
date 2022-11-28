package com.ecommerce.controller;

import com.ecommerce.dao.definition.UserDao;
import com.ecommerce.dto.UserDto;
import com.ecommerce.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignupController {

    @Autowired
    private UserDao userDao;

    @GetMapping("signup")
    public ModelAndView create(Model model){

        model.addAttribute("userDto", new UserDto());
        return new ModelAndView("auth/signup","model",model);

    }

    @PostMapping("views/auth/signup")
    public String store(Model model, @ModelAttribute("user") UserDto userDto){

        User user = new User();
        user.setUserName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        userDao.registerUser(user);

        return "redirect:/productDisplay";
    }
}
