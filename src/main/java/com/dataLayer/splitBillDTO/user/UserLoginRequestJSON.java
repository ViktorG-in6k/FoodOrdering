package com.dataLayer.splitBillDTO.user;

public class UserLoginRequestJSON {
    private String email;

    public UserLoginRequestJSON() {
    }

    public UserLoginRequestJSON(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

