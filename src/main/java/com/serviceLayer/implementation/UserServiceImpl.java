package com.serviceLayer.implementation;

import com.dataLayer.DAO.UserDAO;
import com.model.User;
import com.serviceLayer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by employee on 3/29/16.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDAO userDAO;

    public void saveUser(User person){
        userDAO.save(person);
    }

    public User getUser(long id){
        return userDAO.getUser(id);
    }

    public User getUserByEmail(String email){
        return userDAO.getUserByEmail(email);
    }
}
