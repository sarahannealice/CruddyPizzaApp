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
}
