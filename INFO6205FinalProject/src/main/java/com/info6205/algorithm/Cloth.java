package com.info6205.algorithm;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Cloth {
    private String color;
    private String material;
    private  StringProperty colorp;
    private StringProperty materialp;



    public Cloth(String color,String material){
        this.color=color;
        this.material=material;
    }
    public String getColor(){
        return color;
    }
    public String getMaterial(){
        return material;
    }
    public StringProperty colorProperty() {
        colorp=new SimpleStringProperty();
        colorp.setValue(color);
        return colorp;
    }
    public StringProperty materialProperty() {
        materialp=new SimpleStringProperty();
        materialp.setValue(material);
        return materialp;
    }
}
