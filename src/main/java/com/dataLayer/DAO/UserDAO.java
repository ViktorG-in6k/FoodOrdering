package com.dataLayer.DAO;

import com.model.user;


public interface UserDAO {

    public void save(user person);

    public user getUser(long id);

    public user getUserByEmail(String email);
}
