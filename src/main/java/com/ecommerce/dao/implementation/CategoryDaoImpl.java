package com.ecommerce.dao.implementation;

import com.ecommerce.dao.definition.CategoryDao;
import com.ecommerce.entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("categoryDAO")
@Transactional
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
     private SessionFactory sessionFactory;

    @Override
    public boolean addCategory(Category category) {

        Session session = sessionFactory.getCurrentSession();
        try{
            session.save(category);
            return true;
        }
        catch (Exception e){
            return false;
        }

    }

    @Override
    public boolean deleteCategory(Category category) {

        Session session= sessionFactory.getCurrentSession();

        try {
            session.delete(category);
            return true;
        }
        catch (Exception e){

            return false;
        }
    }

    @Override
    public boolean updateCategory(Category category) {

        Session session = sessionFactory.getCurrentSession();

        try {
            session.update(category);
            return true;
        }
        catch (Exception e){

            return false;
        }
    }

    @Override
    public List<Category> listCategory() {

        Session session = sessionFactory.openSession();

        Query query= session.createQuery("from Category");
        List<Category> listCategories = query.list();
        session.close();
        return listCategories;
    }

    @Override
    public Category getCategory(int categoryId) {

        Session session= sessionFactory.openSession();
        Category category= session.get(Category.class, categoryId);
        return category;
    }
}
