package com.info6205.algorithm;

public class Order {
    //this class forms as BAG!!!
    private int orderID;
    private Cloth[]cloths;
    private String status;
    private double totalPrice;
    private PendingClothGroup[]groups;

    public Order(int orderID,Cloth[]cloths) {
        this.orderID=orderID;
        this.cloths=cloths;
        this.status="unfinished";
        this.totalPrice=0;
    }



    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Cloth[] getCloths() {
        return cloths;
    }

    public void setCloths(Cloth[] cloths) {
        this.cloths = cloths;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public PendingClothGroup[] getGroups() {
        return groups;
    }

    public void setGroups(PendingClothGroup[] groups) {
        this.groups = groups;
    }
}
