package com.example.englishwordapp.dtos;

public class DtoUser {

    public String userName;
    public String email;

    public DtoUser() {
    }
    public DtoUser(String name, String email) {
        this.userName = name;
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getData() {
        return "User{" +
                "userName='" + userName +
                "', email='" + email +
                "'}";
    }
}
