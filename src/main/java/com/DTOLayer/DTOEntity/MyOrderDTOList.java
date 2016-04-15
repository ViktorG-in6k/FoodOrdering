package com.DTOLayer.DTOEntity;

import com.model.Entity.Order;

import java.util.ArrayList;
import java.util.List;

public class MyOrderDTOList {
    private List<MyOrderDTO> myOrderList;

    public MyOrderDTOList(List<Order>orderList){

        myOrderList = new ArrayList<>();
        for(Order order: orderList){
            boolean k = false;
            for (MyOrderDTO myOrder: myOrderList) {
                if(myOrder.getItem().getId()==order.getItem().getId()){
                    myOrder.setCount(myOrder.getCount()+1);
                    k=true;
                    break;
                }
            }
            if(!k){
                myOrderList.add(new MyOrderDTO(order.getItem()));
            }
        }
    }

    public List<MyOrderDTO> getMyOrderList(){
        return myOrderList;
    }

    public void setMyOrderList(List<MyOrderDTO> myOrderList){
        this.myOrderList = myOrderList;
    }
}
