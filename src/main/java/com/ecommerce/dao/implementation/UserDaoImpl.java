package com.ecommerce.dao.implementation;

import com.ecommerce.dao.definition.UserDao;
import com.ecommerce.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("UserDAO")
@Transactional
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
}
