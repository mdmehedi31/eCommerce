package com.ecommerce.dao.implementation;

import com.ecommerce.dao.definition.SupplierDao;
import com.ecommerce.entity.Supplier;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Component
public class SupplierDaoImpl implements SupplierDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean addSupplier(Supplier supplier) {
        Session session= sessionFactory.getCurrentSession();

        try{
            session.save(supplier);
            return true;
        }
        catch (Exception e){
             return false;
        }
    }

    @Override
    public boolean deleteSupplier(Supplier supplier) {
        Session session = sessionFactory.getCurrentSession();

        try {
            session.delete(supplier);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateSupplier(Supplier supplier) {

        Session session=sessionFactory.getCurrentSession();

        try {
            session.update(supplier);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public List<Supplier> listSuppliers() {
        Session session= sessionFactory.openSession();

        Query query =session.createQuery("from Supplier");
        List<Supplier> supplierList= query.list();
        session.close();
        return supplierList;
    }

    @Override
    public Supplier getSupplier(int supplierId) {

        Session session= sessionFactory.openSession();
        Supplier supplier = session.get(Supplier.class, supplierId);
        session.close();
        return supplier;
    }
}
