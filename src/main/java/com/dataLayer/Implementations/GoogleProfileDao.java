package com.dataLayer.Implementations;

;
import com.model.Entity.GoogleProfile;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("unchecked")
@Repository
@Transactional
public class GoogleProfileDao {
    @Autowired
    SessionFactory sessionFactory;

    public void save(GoogleProfile googleProfile) {
        Session session = sessionFactory.getCurrentSession();
        session.save(googleProfile);
    }

    public GoogleProfile getGoogleProfileByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from GoogleProfile where email = :email");
        query.setString("email", email);
        return (GoogleProfile) query.uniqueResult();
    }
}

