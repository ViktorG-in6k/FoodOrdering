package com.Classes;
import com.model.Restaurant;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
public class AllList {
    private Restaurant restaurant;
    private List<DataForOrder> orderLists;
    private BigDecimal cost;
    public AllList(Restaurant restaurant, OrderList orderList){
        orderLists = new ArrayList<DataForOrder>();
        for (DataForOrder data: orderList.getOrderList()) {
            if(data.getItem().getRestaurant().getName().equals(restaurant.getName())) {
                orderLists.add(data);
            }
        }
        cost = new BigDecimal(0);
        for (DataForOrder c: orderLists) {
            cost = cost.add(c.getCost());
        }
        this.restaurant=restaurant;

    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<DataForOrder> getOrderList() {
        return orderLists;
    }

    public void setOrderList(List<DataForOrder> orderList) {
        this.orderLists = orderList;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}