package com.dataLayer.entity.DTO.restaurantDTO;

import com.dataLayer.entity.DTO.itemDTO.ItemDTO;
import com.dataLayer.entity.DTO.orderDTO.OrderPlacementStatus;
import com.dataLayer.entity.base.Restaurant;
import java.util.ArrayList;
import java.util.List;

public class RestaurantDTO {
    protected int id;
    protected String name;
    protected String phone;
    protected String link;
    private OrderPlacementStatus orderPlacementStatus;
    private List<ItemDTO> itemList = new ArrayList<ItemDTO>();
    private int activeOrderAmountByRestaurant;

    public RestaurantDTO(Restaurant restaurant, OrderPlacementStatus orderPlacementStatus, int activeOrderAmountByRestaurant) {
        this(restaurant);
        this.orderPlacementStatus = orderPlacementStatus;
        this.activeOrderAmountByRestaurant = activeOrderAmountByRestaurant;
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

    public int getActiveOrderAmountByRestaurant() {
        return activeOrderAmountByRestaurant;
    }

    public void setActiveOrderAmountByRestaurant(int activeOrderAmountByRestaurant) {
        this.activeOrderAmountByRestaurant = activeOrderAmountByRestaurant;
    }
}

