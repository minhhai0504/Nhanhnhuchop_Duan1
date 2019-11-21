package com.example.nhanhnhuchop_duan1.model;

public class User {
    String ID, username, password, point;

    public User(String ID, String username, String password, String point) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.point = point;
    }

    public User() {
    }


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }
}


