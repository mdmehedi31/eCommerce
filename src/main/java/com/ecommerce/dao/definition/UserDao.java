package com.ecommerce.dao.definition;

import com.ecommerce.entity.User;

public interface UserDao {

    public boolean registerUser(User user);
    public boolean updateUser(User user);
    public User getUser(String userName);
    public User findByEmail(String email);
    public User findByUsername(String username);
}
