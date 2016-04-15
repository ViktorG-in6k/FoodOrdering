package com.DTOLayer.JSON;

import com.model.Entity.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderJson {
    private int idUser;
    private String emailUser;
    List<RestaurantJson>restaurantJsonList;

    public  OrderJson(List<Order>orderList){
        idUser=orderList.get(0).getEvent().getUser().getId();
        emailUser=orderList.get(0).getEvent().getUser().getEmail();

        restaurantJsonList = new ArrayList<>();

        for (Order order: orderList) {
            setInRestaurantJsonList(order);

        }
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    void setInRestaurantJsonList(Order order){
        boolean k = false;
        for (RestaurantJson restaurantJson: restaurantJsonList) {
            if(restaurantJson.getId() == order.getItem().getRestaurant().getId()){

                restaurantJson.setInItemsList(order);
                k=true;
                break;
            }

        }
        if(!k){
            restaurantJsonList.add(new RestaurantJson(order));
        }
    }
}
