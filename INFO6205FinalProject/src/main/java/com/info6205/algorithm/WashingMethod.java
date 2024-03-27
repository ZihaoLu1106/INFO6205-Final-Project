

package com.info6205.algorithm;

public class WashingMethod {

    private String methodName;
    private double price;
    private int duration;

    public WashingMethod(String methodName, double price, int duration) {
        this.methodName = methodName;
        this.price = price;
        this.duration = duration;


    }

    public String getMethodName() {
        return methodName;
    }

}

