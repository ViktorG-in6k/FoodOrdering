package com.DTOLayer.DTOEntity;

import com.model.Entity.Item;
import com.model.Entity.Restaurant;
import com.model.Entity.User;

import java.util.ArrayList;
import java.util.List;

public class RestaurantDTO {
    protected int id;
    protected String name;
    protected String phone;
    protected String link;
    private UserDTO userResponsibility;

    public List<ItemDTO> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemDTO> itemList) {
        this.itemList = itemList;
    }

    private List<ItemDTO> itemList = new ArrayList<ItemDTO>();

    public RestaurantDTO(Restaurant restaurant) {
        this.id = restaurant.getId();
        this.name = restaurant.getName();
        this.phone = restaurant.getPhone();
        this.link = restaurant.getLink();
        for (Item item : restaurant.getItem()) {
            this.itemList.add(new ItemDTO(item));
        }
    }

    public RestaurantDTO(Restaurant restaurant, User user) {
        this.id = restaurant.getId();
        this.name = restaurant.getName();
        this.phone = restaurant.getPhone();
        this.link = restaurant.getLink();
        for (Item item : restaurant.getItem()) {
            this.itemList.add(new ItemDTO(item));
        }
        this.userResponsibility = new UserDTO(user);
    }

    public RestaurantDTO(Restaurant restaurant, UserDTO user) {
        this.id = restaurant.getId();
        this.name = restaurant.getName();
        this.phone = restaurant.getPhone();
        this.link = restaurant.getLink();
        for (Item item : restaurant.getItem()) {
            this.itemList.add(new ItemDTO(item));
        }
        this.userResponsibility = user;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getLink() {
        return link;
    }

    public int getId() {
        return id;
    }

    public UserDTO getUserResponsibility() {
        return userResponsibility;
    }

    public void setUserResponsibility(UserDTO userResponsibility) {
        this.userResponsibility = userResponsibility;
    }
}

