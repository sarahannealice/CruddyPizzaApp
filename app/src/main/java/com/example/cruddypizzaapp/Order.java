package com.example.cruddypizzaapp;

public class Order {
    int orderNum;
    String name;
    String phone;
    int size;
    int top1;
    int top2;
    int top3;

    //default constructor
    Order() {
        name = "";
        phone = "";
        size = 0;
        top1 = 0;
        top2 = 0;
        top3 = 0;
    }

    //constructor
    Order(int orderNum, String name, String phone, int size, int top1, int top2, int top3) {
        this.orderNum = orderNum;
        this.name = name;
        this.phone = phone;
        this.size = size;
        this.top1 = top1;
        this.top2 = top2;
        this.top3 = top3;
    }

    //variable
    String print = null;

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
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


    public String getSize() {
        switch(size) {
            case 1:
                print = "small";
                break;
            case 2:
                print = "medium";
                break;
            case 3:
                print = "large";
                break;
            case 4:
                print = "x-large";
                break;
        }
        return print;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getTop1() {
        switch (top1) {
            case 1:
                print = "green pepper";
                break;
            case 2:
                print = "mushroom";
                break;
            case 3:
                print = "pepperoni";
                break;
            case 4:
                print = "sausage";
                break;
            case 5:
                print = "diced ham";
                break;
            case 6:
                print = "pineapple";
                break;
        }
        return print;
    }

    public void setTop1(int top1) {
        this.top1 = top1;
    }

    public String getTop2() {
        switch (top2) {
            case 1:
                print = "green pepper";
                break;
            case 2:
                print = "mushroom";
                break;
            case 3:
                print = "pepperoni";
                break;
            case 4:
                print = "sausage";
                break;
            case 5:
                print = "diced ham";
                break;
            case 6:
                print = "pineapple";
                break;
            default:
                print = "";
                break;
        }
        return print;
    }

    public void setTop2(int top2) {
        this.top2 = top2;
    }

    public String getTop3() {
        switch (top3) {
            case 1:
                print = "green pepper";
                break;
            case 2:
                print = "mushroom";
                break;
            case 3:
                print = "pepperoni";
                break;
            case 4:
                print = "sausage";
                break;
            case 5:
                print = "diced ham";
                break;
            case 6:
                print = "pineapple";
                break;
            default:
                print = "";
                break;
        }
        return print;
    }

    public void setTop3(int top3) {
        this.top3 = top3;
    }
}
