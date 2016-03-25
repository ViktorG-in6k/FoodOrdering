package com.dataLayer.DAO;

import com.model.user;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserDAO {

    @Autowired
    SessionFactory sessionFactory ;

    public void save(user person);

    public user getUser(long id);

    public user getUserByEmail(String email);
}
