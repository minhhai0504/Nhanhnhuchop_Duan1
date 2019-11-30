package com.example.nhanhnhuchop_duan1.model;

public class User {
    public String ID, username, password;
    public int point;

    public User(String ID, String username, String password, int point) {
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

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}


