package com.serviceLayer.service;

import com.model.Entity.GoogleProfile;
import com.model.Entity.User;
import com.model.base.OauthProfile;

import java.util.List;

public interface UserService {
    public void saveUser(User person);

    public void saveUser(String email);

    public User getUser(long id);

    public User getUserByEmail(String email);

    public List<User> getListOfAllUsers();

    public User getUserFromOauthUser(OauthProfile oauthProfile);
}

