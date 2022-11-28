package com.ecommerce.dao.implementation;

import com.ecommerce.dao.definition.ProductDao;
import com.ecommerce.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Component
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean addProduct(Product product) {

        Session session = sessionFactory.getCurrentSession();

        try{
            session.save(product);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteProduct(Product product) {

        Session session=sessionFactory.getCurrentSession();

        try{
            session.delete(product);
            return true;
        }
        catch (Exception e){

            return false;
        }

    }

    @Override
    public boolean updateProduct(Product product) {
        Session session= sessionFactory.getCurrentSession();

        try{
            session.update(product);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public List<Product> listProduct() {

        Session session= sessionFactory.openSession();

        Query query= session.createQuery("from Product ");
        List<Product> listProduct= query.list();
        session.close();
        return listProduct;
    }

    @Override
    public Product getProduct(int productId) {

        Session session =sessionFactory.openSession();
        Product product= session.get(Product.class,productId);
        session.close();

        return product;

    }

    /*@Override
    public String getCategoryByProductId(int productId) {

        Session session= sessionFactory.openSession();
        Query name=session.createQuery(" select  from tbproduct where productId=:productId");
    }
*/

}
