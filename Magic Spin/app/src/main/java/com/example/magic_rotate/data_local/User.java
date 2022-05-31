package com.example.magic_rotate.data_local;

public class User {
    private int number;
    private String name;
    private int point;


    public User(String name, int point) {
        this.name = name;
        this.point = point;
    }

    public User() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", point=" + point +
                '}';
    }


}
