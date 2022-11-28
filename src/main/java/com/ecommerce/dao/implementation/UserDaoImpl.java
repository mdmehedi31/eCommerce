package com.ecommerce.dao.implementation;

import com.ecommerce.dao.definition.UserDao;
import com.ecommerce.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean registerUser(User user) {

        Session session = sessionFactory.getCurrentSession();

        try {
             session.save(user);
             return true;
        }
        catch (Exception e){
            return false;
        }

    }

    @Override
    public boolean updateUser(User user) {
        Session session= sessionFactory.getCurrentSession();
        try {
            session.update(user);
            return true;
        }
        catch (Exception e){
            return false;
        }

    }

    @Override
    public User getUser(String userName) {

        Session session=sessionFactory.openSession();
        User userDetails =session.get(User.class, userName);
        session.close();
        return userDetails;
    }

    @Override
    public User findByEmail(String email) {
        List<User> users = sessionFactory.getCurrentSession()
                .createQuery("FROM User WHERE email = :email", User.class)
                .setParameter("email", email)
                .getResultList();
        return users.size() > 0 ? users.get(0) : null;
    }

    public User findByUsername(String username) {
        List<User> users = sessionFactory.getCurrentSession()
                .createQuery("FROM User WHERE userName= :username", User.class)
                .setParameter("username", username.toLowerCase())
                .getResultList();
        return users.size() > 0 ? users.get(0) : null;
    }
}
