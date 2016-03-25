package com.service;

import com.dao.PersonDAO;
import com.model.Person;
import com.model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    PersonDAO personDAO;

    public void saveUser(user person){
        personDAO.save(person);
    }

    public user getUser(long id){
       return UserDAO.getPerson(id);
    }
}
