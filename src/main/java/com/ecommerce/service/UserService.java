package com.ecommerce.service;


import com.ecommerce.dao.definition.UserDao;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService implements UserDetailsService {


    private final UserDao userDao;


    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

       var user= userDao.findByEmail(email);

       if(user==null){
           throw new UsernameNotFoundException(email);
       }

       return new org.springframework.security.core.userdetails.
               User(user.getEmail(),
               user.getPassword(),
               user.getAuthorities());


      /*  return email.contains("@") ? userDao.findByEmail(email) :
                userDao.findByUsername(email);*/
    }


}
