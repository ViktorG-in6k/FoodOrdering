package com.Classes;


import com.model.Restaurant;

public class AllList {
    private Restaurant restaurant;
    private OrderList orderList;

    public AllList(Restaurant restaurant, OrderList orderList){

        for (DataForOrder data: orderList.getOrderList()) {
            if(data.getItem().getRestaurant()!=restaurant)
                data = null;
        }
        this.restaurant=restaurant;
        this.orderList=orderList;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public OrderList getOrderList() {
        return orderList;
    }

    public void setOrderList(OrderList orderList) {
        this.orderList = orderList;
    }
}
