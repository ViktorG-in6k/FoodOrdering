package com.serviceLayer.service;

import com.dataLayer.entity.User;
import com.dataLayer.entity.base.OauthProfile;

public interface UserService {
    public void saveUser(User person);

    public void saveUser(String email);

    public User getUser(long id);

    public User getUserByEmail(String email);

    public User getUserFromOauthUser(OauthProfile oauthProfile);
}

