package com.splitBill.splitBillDTO.login;

public class LoginDTO {
    private String email;

    public LoginDTO(){}

    public LoginDTO(String email){
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
