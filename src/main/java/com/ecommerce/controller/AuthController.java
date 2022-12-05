package com.ecommerce.controller;

import com.ecommerce.dao.definition.UserDao;
import com.ecommerce.entity.User;
import com.ecommerce.enums.Role;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/auth")
public class AuthController {


    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;


    public AuthController(UserDao userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;

    }

    @GetMapping("/login")
    public ModelAndView login(Model model, @RequestParam(name = "error",
            required = false)  String error){

        var mv= new ModelAndView();
        createDemoUser();
        mv.addObject("error", error);
        mv.setViewName("auth/login");
        return mv;
    }


    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication){

        if (authentication != null){
            new SecurityContextLogoutHandler().logout(request,response ,authentication);
        }

        return "redirect:auth/login";
    }
    protected void createDemoUser(){

        if (userDao.findByEmail("user1@gmail.com")==null) {

            User user1= new User();

            user1.setUserName("user1");
            user1.setPassword(passwordEncoder.encode("user1"));
            user1.setEmail("user1@gmail.com");
            user1.setRole(Role.ROLE_USER);
            user1.setEnabled(true);
            userDao.registerUser(user1);

        }

        if (userDao.findByEmail("admin@gmail.com")==null){

            User admin= new User();
            admin.setUserName("admin");
            admin.setPassword(passwordEncoder.encode("admin"));
            admin.setEmail("admin@gmail.com");
            admin.setRole(Role.ROLE_ADMIN);
            admin.setEnabled(true);

            userDao.registerUser(admin);
        }

    }
}
