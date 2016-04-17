package com.DTOLayer.DTOEntity.orderDTO;

import com.DTOLayer.DTOEntity.RestaurantDTO;
import com.model.Entity.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderDTOList {
    private List<OrderDTOItemCount> myOrderList;

    public OrderDTOList(List<Order>orderList){

        myOrderList = new ArrayList<>();
        for(Order order: orderList){
            boolean k = false;
            for (OrderDTOItemCount myOrder: myOrderList) {
                if(myOrder.getItem().getId()==order.getItem().getId()){
                    myOrder.setCount(myOrder.getCount()+1);
                    k=true;
                    break;
                }
            }
            if(!k){
                myOrderList.add(new OrderDTOItemCount(order.getItem()));
            }
        }
    }

    public List<OrderDTOItemCount> getMyOrderList(){
        return myOrderList;
    }

    public void setMyOrderList(List<OrderDTOItemCount> myOrderList){
        this.myOrderList = myOrderList;
    }
}
