package com.serviceLayer.service;

import com.dataLayer.entity.DTO.userDTO.UserDTO;
import com.dataLayer.entity.base.User;
import com.dataLayer.entity.external.OauthProfile;

import java.util.List;
import java.util.Set;

public interface UserService {
    public void saveUser(User person);

    public void saveUser(String email);

    public User getUser(long id);

    public User getUserByEmail(String email);

    Set<UserDTO> getUnusedUsersFromItemOrder(int orderId, int itemId, String name);

    public User getUserFromOauthUser(OauthProfile oauthProfile);
}

