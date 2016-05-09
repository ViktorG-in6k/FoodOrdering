package com.dataLayer.Implementations;

import com.dataLayer.DAO.StatusDAO;
import com.model.Entity.Status;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("unchecked")
@Repository
@Transactional
public class StatusDAOImpl implements StatusDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Status getStatusById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from status where id =: id");
        return (Status) query.setInteger("id", id);
    }
}

