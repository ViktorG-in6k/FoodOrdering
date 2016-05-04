package com.DTOLayer.DTOEntity.orderDTO;

import com.DTOLayer.DTOEntity.restaurantDTO.RestaurantDTOforOrder;
import com.model.Entity.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderDTOList {
    private int eventId;
    private List<OrderDTOItemCount> orderList;
    private RestaurantDTOforOrder restaurant;

    public OrderDTOList() {
    }

    public OrderDTOList(List<Order> orderList, int eventId) {
        this.orderList = new ArrayList<>();
        for (Order order : orderList) {
            this.orderList.add(new OrderDTOItemCount(order));
        }
        this.eventId = eventId;
        if(orderList.size()>0) {
            this.restaurant = new RestaurantDTOforOrder(orderList.get(0).getRestaurant());
        }
    }

    public OrderDTOList(int restaurantId, List<Order> orderList) {
        this.orderList = new ArrayList<>();
        for (Order order : orderList) {
            if (order.getItem().getRestaurant().getId() == restaurantId) {
                this.orderList.add(new OrderDTOItemCount(order));
            }
        }
        if(orderList.size()>0) {
            this.eventId = orderList.get(0).getId();
            this.restaurant = new RestaurantDTOforOrder(orderList.get(0).getRestaurant());
        }
    }

    public List<OrderDTOItemCount> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderDTOItemCount> orderList) {
        this.orderList = orderList;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public RestaurantDTOforOrder getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(RestaurantDTOforOrder restaurant) {
        this.restaurant = restaurant;
    }
}

