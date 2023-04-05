package com.example.cruddypizzaapp;

public class Order {
    int orderNum;
    String name;
    String phone;
    int top1;
    int top2;
    int top3;

    Order (int orderNum, String name, String phone, int top1, int top2, int top3) {
        this.orderNum = orderNum;
        this.name = name;
        this.phone = phone;
        this.top1 = top1;
        this.top2 = top2;
        this.top3 = top3;
    }
}
