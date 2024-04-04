package com.info6205.algorithm;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.List;

public class PendingClothGroup {
    private String orderID;
    private String status;//Pending;Processing;Finished
    private  WashingMethod method;
    private List<Cloth> cloths;
    private int duration;

    private SimpleStringProperty idp;

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    private double price;

    public PendingClothGroup(String orderID, WashingMethod method) {
        this.orderID = orderID;
        cloths=new ArrayList<>();
        this.method = method;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public WashingMethod getMethod() {
        return method;
    }

    public void setMethod(WashingMethod method) {
        this.method = method;
    }

    public List<Cloth> getCloths() {
        return cloths;
    }

    public void setCloths(List<Cloth> cloths) {
        this.cloths = cloths;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public StringProperty idProperty() {
        idp=new SimpleStringProperty();
        idp.setValue(this.orderID);
        return idp;
    }
    public StringProperty numProperty() {
        SimpleStringProperty nump=new SimpleStringProperty();
        nump.setValue(String.valueOf(this.cloths.size()));
        return nump;
    }
    public StringProperty durationProperty() {
        SimpleStringProperty durationp=new SimpleStringProperty();
        durationp.setValue(String.valueOf(this.duration));
        return durationp;
    }
    public StringProperty methodProperty() {
        SimpleStringProperty methodp=new SimpleStringProperty();
        methodp.setValue(this.method.getMethodName());
        return methodp;
    }
}
