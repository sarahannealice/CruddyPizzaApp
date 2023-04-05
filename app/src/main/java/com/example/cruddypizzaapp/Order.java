package com.example.cruddypizzaapp;

public class Order {
    String name;
    String phone;
    int size;
    int top1;
    int top2;
    int top3;

    //constructor
    Order (String name, String phone, int size, int top1, int top2, int top3) {
        this.name = name;
        this.phone = phone;
        this.size = size;
        this.top1 = top1;
        this.top2 = top2;
        this.top3 = top3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTop1() {
        return top1;
    }

    public void setTop1(int top1) {
        this.top1 = top1;
    }

    public int getTop2() {
        return top2;
    }

    public void setTop2(int top2) {
        this.top2 = top2;
    }

    public int getTop3() {
        return top3;
    }

    public void setTop3(int top3) {
        this.top3 = top3;
    }
}
