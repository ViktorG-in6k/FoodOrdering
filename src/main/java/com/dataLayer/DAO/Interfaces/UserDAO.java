package com.dataLayer.DAO.Interfaces;

import com.dataLayer.entity.base.User;

import java.util.List;

public interface UserDAO {
    public void save(User person);

    public User getUser(long id);

    public User getUserByEmail(String email);

    public User findUsersByEmail(String email);

    public List<User> getListOfAllUsers();

    List<User> getListOfUsersByName(String name);
}

