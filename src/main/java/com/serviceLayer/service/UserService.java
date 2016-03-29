package com.serviceLayer.service;

import com.model.User;


public interface UserService {

    public void saveUser(User person);

    public User getUser(long id);

    public User getUserByEmail(String email);

}
