package com.serviceLayer.implementation;

import com.dataLayer.DAO.UserDAO;
import com.model.User;
import com.serviceLayer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDAO userDAO;

    public void saveUser(User person){
        if(getUserByEmail(person.getEmail())==null) {
            userDAO.save(person);
        }
    }

    public void saveUser(String email){
        User user = new User("user",email);
        if(getUserByEmail(user.getEmail())==null) {
            userDAO.save(user);
        }
    }

    public User getUser(long id){
        return userDAO.getUser(id);
    }

    public User getUserByEmail(String email){
        return userDAO.getUserByEmail(email);
    }


}
