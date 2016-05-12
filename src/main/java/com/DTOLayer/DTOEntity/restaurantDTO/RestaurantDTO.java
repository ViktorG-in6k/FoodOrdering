package com.DTOLayer.DTOEntity.restaurantDTO;

import com.DTOLayer.DTOEntity.itemDTO.ItemDTO;
import com.DTOLayer.DTOEntity.orderDTO.OrderPlacementStatus;
import com.model.Entity.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class RestaurantDTO {
    protected int id;
    protected String name;
    protected String phone;
    protected String link;
    private OrderPlacementStatus orderPlacementStatus;
    private List<ItemDTO> itemList = new ArrayList<ItemDTO>();

    public RestaurantDTO(Restaurant restaurant, OrderPlacementStatus orderPlacementStatus) {
        this(restaurant);
        this.orderPlacementStatus = orderPlacementStatus;
    }

    public RestaurantDTO(Restaurant restaurant) {
        this.id = restaurant.getId();
        this.name = restaurant.getName();
        this.phone = restaurant.getPhone();
        this.link = restaurant.getLink();
        restaurant.getItem().forEach(item -> this.itemList.add(new ItemDTO(item)));
    }

    public OrderPlacementStatus getOrderPlacementStatus() {
        return orderPlacementStatus;
    }

    public void setOrderPlacementStatus(OrderPlacementStatus orderPlacementStatus) {
        this.orderPlacementStatus = orderPlacementStatus;
    }

    public List<ItemDTO> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemDTO> itemList) {
        this.itemList = itemList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}

