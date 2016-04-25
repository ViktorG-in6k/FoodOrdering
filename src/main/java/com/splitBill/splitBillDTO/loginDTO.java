package com.splitBill.splitBillDTO;

public class loginDTO {
    private String email;

    public loginDTO(){}

    public loginDTO(String email){
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
