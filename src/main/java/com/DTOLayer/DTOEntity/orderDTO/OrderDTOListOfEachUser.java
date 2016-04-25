package com.DTOLayer.DTOEntity.orderDTO;

public class OrderDTOListOfEachUser {
    private OrderDTOList orderDTOList;
    private String userMail;

    public OrderDTOListOfEachUser(OrderDTOList orderDTOList, String userMail) {
        this.orderDTOList = orderDTOList;
        this.userMail = userMail;
    }

    public OrderDTOListOfEachUser() {
    }

    public OrderDTOList getOrderDTOList() {
        return orderDTOList;
    }

    public void setOrderDTOList(OrderDTOList orderDTOList) {
        this.orderDTOList = orderDTOList;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }
}

