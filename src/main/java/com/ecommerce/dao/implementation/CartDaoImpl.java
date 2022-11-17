package com.ecommerce.dao.implementation;

import com.ecommerce.dao.definition.CartDao;
import com.ecommerce.entity.CartItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Component
public class CartDaoImpl implements CartDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean addCartItem(CartItem cartItem) {

        Session session= sessionFactory.getCurrentSession();
        try{
            session.save(cartItem);
            return true;
        }catch (Exception e){

            return false;
        }
    }

    @Override
    public boolean deleteCartItem(CartItem cartItem) {

        Session session =sessionFactory.getCurrentSession();

        try{
                session.delete(cartItem);
                return true;

        }catch (Exception e){

            return false;
        }

    }

    @Override
    public boolean updateCartItem(CartItem cartItem) {

        Session session = sessionFactory.getCurrentSession();

        try {
            session.update(cartItem);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public CartItem getCartItem(int cartItemId) {

        Session session = sessionFactory.openSession();
        CartItem cartItem = session.get(CartItem.class, cartItemId);
        return cartItem;
    }

    @Override
    public List<CartItem> listCartItems(String userName) {
        Session session =sessionFactory.openSession();
        Query query = session.createQuery("from CartItem where userName=:userName and paymentStatus='NP'");
        query.setParameter("userName",userName);
        List<CartItem> cartItemList= query.getResultList();
        session.close();
        return cartItemList;
    }
}
