package com.ecommerce.dao.implementation;

import com.ecommerce.dao.definition.UserDao;
import com.ecommerce.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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

   /* @Override
    public User findByEmail(String usEmail) {

        Query query = sessionFactory.getCurrentSession().
                createQuery("from User where email=: usEmail", User.class);
        query.setParameter("usEmail", usEmail);
        return (User) query.list().get(0);
    }*/

    @Override
    public User findByEmail(String usEmail) {
        List<User> users = sessionFactory.getCurrentSession()
                .createQuery("from User where email=:usEmail", User.class)
                .setParameter("usEmail", usEmail)
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
