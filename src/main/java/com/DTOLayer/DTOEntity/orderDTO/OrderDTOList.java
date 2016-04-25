package com.DTOLayer.DTOEntity.orderDTO;

import com.model.Entity.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderDTOList {
    private int eventId;
    private List<OrderDTOItemCount> myOrderList;

    public OrderDTOList() {

    }

    public OrderDTOList(List<Order> orderList, int eventId) {
        myOrderList = new ArrayList<>();
        for (Order order : orderList) {
            boolean k = false;
            for (OrderDTOItemCount myOrder : myOrderList) {
                if (myOrder.getItem().getId() == order.getItem().getId()) {
                    myOrder.setCount(myOrder.getCount() + 1);
                    k = true;
                    break;
                }
            }
            if (!k) {
                myOrderList.add(new OrderDTOItemCount(order));
            }
        }
        this.eventId = eventId;
    }

    public List<OrderDTOItemCount> getMyOrderList() {
        return myOrderList;
    }

    public void setMyOrderList(List<OrderDTOItemCount> myOrderList) {
        this.myOrderList = myOrderList;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }
}

