package com.ecommerce.dao.implementation;

import com.ecommerce.dao.definition.AttachmentDao;
import com.ecommerce.entity.Attachment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AttachmentDaoImpl implements AttachmentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Long insertAttachment(Attachment attachment) {

        Long id = -1L;

        Session session= sessionFactory.getCurrentSession();

        try{
            id =(Long) session.save(attachment);
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        return id;
    }

    @Override
    public void insertBulkAttachment(List<Attachment> attachments) {

        Session session = sessionFactory.getCurrentSession();
        try{
            attachments.forEach(session::save);
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.flush();
    }

    @Override
    public Attachment findById(Long id) {
        return null;
    }
}
