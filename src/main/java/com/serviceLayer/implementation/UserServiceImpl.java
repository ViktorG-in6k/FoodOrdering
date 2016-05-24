package com.serviceLayer.implementation;

import com.dataLayer.DAO.Interfaces.UserDAO;
import com.dataLayer.entity.DTO.orderItemDTO.OrderItemDTO;
import com.dataLayer.entity.DTO.userDTO.UserDTO;
import com.dataLayer.entity.base.User;
import com.dataLayer.entity.external.OauthProfile;
import com.serviceLayer.service.OrderItemService;
import com.serviceLayer.service.RestaurantService;
import com.serviceLayer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO userDAO;
    @Autowired
    OrderItemService orderItemService;

    @Override
    public void saveUser(User user) {
        if (getUserByEmail(user.getEmail()) == null) {
            userDAO.save(user);
        }
    }

    @Override
    public void saveUser(String email) {
        if (getUserByEmail(email) == null) {
            userDAO.save(new User(email));
        }
    }

    @Override
    public User getUser(long id) {
        return userDAO.getUser(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userDAO.getUserByEmail(email);
    }

    @Override
    public Set<UserDTO> getUnusedUsersFromItemOrder(int orderId, int itemId, String name) {
        List<OrderItemDTO> orderItemDTOs = orderItemService.getOrderListByOrderIdAndItemId(orderId, itemId);
        List<User> users = userDAO.getListOfUsersByName(name);
        Set<UserDTO> userDTOs = new HashSet<>();
        for (User user : users) {
            boolean isEqual = false;
            for (OrderItemDTO orderItemDTO : orderItemDTOs) {
                if (user.getId() == orderItemDTO.getUser().getId()) {
                    isEqual = true;
                    break;
                }
            }
            if(!isEqual){
                userDTOs.add(new UserDTO(user));
            }
        }
        return userDTOs;
    }

    @Override
    public User getUserFromOauthUser(OauthProfile oauthProfile) {
        User user = new User();
        user.setName(oauthProfile.getGivenName());
        user.setEmail(oauthProfile.getEmail());
        user.setFamilyName(oauthProfile.getFamilyName());
        user.setGender(oauthProfile.getGender());
        user.setPicture(oauthProfile.getPicture());
        return user;
    }
}

