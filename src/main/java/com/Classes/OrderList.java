package com.Classes;


import com.model.Menu;

import java.util.ArrayList;
import java.util.List;

public class OrderList {
    private List<DataForOrder> orderList;

    public List<DataForOrder> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<DataForOrder> orderList) {
        this.orderList = orderList;
    }

    public OrderList(List<Menu> orders){
        orderList = new ArrayList<DataForOrder>();
        boolean cond;
        for (Menu item: orders) {
            cond = false;
            for (DataForOrder data: orderList) {
                if(item==data.getItem()){
                    data.setCount(data.getCount()+1);
                    data.setCost(data.getCost().add(data.getItem().getPrice()));
                    cond=true;
                    break;
                }
            }
            if(!cond){
                orderList.add(new DataForOrder(item,1));
            }
        }
    }


}
