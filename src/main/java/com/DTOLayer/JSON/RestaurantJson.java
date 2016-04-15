package com.DTOLayer.JSON;

import com.model.Entity.Order;

import java.util.ArrayList;
import java.util.List;

public class RestaurantJson {
    private int id;
    private String name;
    private String description;

    private List<ItemJson>itemJsonList;

    public RestaurantJson(Order order){
        id = order.getItem().getRestaurant().getId();
        name = order.getItem().getRestaurant().getName();
        description = order.getItem().getRestaurant().getDescription();
        itemJsonList = new ArrayList<>();
        itemJsonList.add(new ItemJson(order.getItem()));
    }

    public void setInItemsList(Order order){
        boolean k = false;
        for (ItemJson item: itemJsonList) {
            if(order.getItem().getId() == item.getId()){
                item.setCount(item.getCount()+1);
                k = true;
                break;
            }

        }
        if(!k){
            itemJsonList.add(new ItemJson(order.getItem()));
        }
    }

    public List<ItemJson> getItemJsonList(){
        return itemJsonList;
    }

    public void setItemJsonList(List<ItemJson>items){
        itemJsonList = items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
