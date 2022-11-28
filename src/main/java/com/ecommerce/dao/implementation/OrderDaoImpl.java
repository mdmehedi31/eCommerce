package com.ecommerce.dao.implementation;

import com.ecommerce.dao.definition.OrderDao;
import com.ecommerce.entity.OrderDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;

@Service
@Transactional
public class OrderDaoImpl implements OrderDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public boolean saveOrder(OrderDetail orderDetail) {
       try {
           sessionFactory.getCurrentSession().save(orderDetail);
           return true;
       }catch (Exception e){
        return false;
       }
    }
//createQuery("update tbCartItem set price='p' where userName=:userName");
    @Override
    public boolean updateCart(String userName) {

        Session session=sessionFactory.getCurrentSession();

        Query query=session.createQuery("update tbcartitem set paymentstatus='P' where username=:uname");
        query.setParameter("uname",userName);
        int row_eff= query.executeUpdate();
        //session.Close()
        if(row_eff>0){
            return true;
        }
        else {
            return false;
        }
    }
}
