package com.service;

import com.dataLayer.DAO.UserDAO;
import com.model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

    public void saveUser(user person){
        userDAO.save(person);
    }

    public user getUser(long id){
       return userDAO.getUser(id);
    }

    public user getUserByEmail(String email){
        return userDAO.getUserByEmail(email);
    }
}
