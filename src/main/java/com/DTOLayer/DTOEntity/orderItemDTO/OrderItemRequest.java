package com.DTOLayer.DTOEntity.orderItemDTO;

import com.DTOLayer.DTOEntity.eventDTO.EventDTO;
import com.DTOLayer.DTOEntity.itemDTO.ItemDTO;
import com.DTOLayer.DTOEntity.orderDTO.OrderDTO;
import com.DTOLayer.DTOEntity.restaurantDTO.RestaurantDTO;

public class OrderItemRequest {
    private ItemDTO item;
    private OrderDTO order;
    private RestaurantDTO restaurant;
    private EventDTO event;

    public OrderItemRequest() {
    }

    public OrderItemRequest(ItemDTO item, OrderDTO order, RestaurantDTO restaurant, EventDTO event) {
        this.item = item;
        this.order = order;
        this.restaurant = restaurant;
        this.event = event;
    }

    public ItemDTO getItem() {
        return item;
    }

    public void setItem(ItemDTO item) {
        this.item = item;
    }

    public OrderDTO getOrder() {
        return order;
    }

    public void setOrder(OrderDTO order) {
        this.order = order;
    }

    public RestaurantDTO getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(RestaurantDTO restaurant) {
        this.restaurant = restaurant;
    }

    public EventDTO getEvent() {
        return event;
    }

    public void setEvent(EventDTO event) {
        this.event = event;
    }
}

