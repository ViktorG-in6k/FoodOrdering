package com.DTOLayer.DTOEntity.orderDTO;

import com.DTOLayer.DTOEntity.ItemDTO;
import com.DTOLayer.DTOEntity.restaurantDTO.RestaurantDTOforOrder;
import com.model.Entity.Order;

class OrderDTOItemCount {
    private ItemDTO item;
    private int count;
    private RestaurantDTOforOrder restaurant;
    private boolean ordered;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ItemDTO getItem() {
        return item;
    }

    public void setItem(ItemDTO item) {
        this.item = item;
    }

    public OrderDTOItemCount(Order order) {
        this.item = new ItemDTO(order.getItem());
        count = 1;
        this.restaurant = new RestaurantDTOforOrder(order.getItem().getRestaurant());
        this.ordered = order.isOrdered();
    }

    public RestaurantDTOforOrder getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(RestaurantDTOforOrder restaurant) {
        this.restaurant = restaurant;
    }

    public boolean isOrdered() {
        return ordered;
    }

    public void setOrdered(boolean ordered) {
        this.ordered = ordered;
    }
}

