package com.DTOLayer.DTOEntity.orderDTO;

import com.DTOLayer.DTOEntity.UserDTO;

import java.util.List;

public class OrderDTOListOfEachUser {
    private List<OrderDTOList> orderDTOList;
    private String userMail;

    public OrderDTOListOfEachUser(List<OrderDTOList> orderDTOList, UserDTO userDTO){
        this.orderDTOList = orderDTOList;
        this.userMail = userDTO.getEmail();
    }

    public void addToOrderList(OrderDTOList orderDTOList){
        this.orderDTOList.add(orderDTOList);
    }

    public List<OrderDTOList> getOrderDTOList() {
        return orderDTOList;
    }

    public void setOrderDTOList(List<OrderDTOList> orderDTOList) {
        this.orderDTOList = orderDTOList;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }
}
