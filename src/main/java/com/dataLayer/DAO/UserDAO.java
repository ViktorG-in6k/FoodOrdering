package com.dataLayer.DAO;

import com.model.User;

public interface UserDAO {

    public void save(User person);

    public User getUser(long id);

    public User getUserByEmail(String email);
}
