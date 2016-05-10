package com.serviceLayer.implementation;

import com.dataLayer.DAO.UserDAO;
import com.model.Entity.User;
import com.serviceLayer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO userDAO;

    public void saveUser(User user) {
        if (getUserByEmail(user.getEmail()) == null) {
            userDAO.save(user);
        }
    }

    public void saveUser(String email) {
        if (getUserByEmail(email) == null) {
            userDAO.save(new User(email));
        }
    }

    public User getUser(long id) {
        return userDAO.getUser(id);
    }

    public User getUserByEmail(String email) {
        return userDAO.getUserByEmail(email);
    }

    public List<User> getListOfAllUsers() {
        return userDAO.getListOfAllUsers();
    }
}

