package com.info6205.algorithm;

public class Order implements BagInterface<Order>{
    //this class forms as BAG!!!
    //add cloths
    private String orderID;
    private Cloth[]cloths;
    private int numberOfEntries;
    private String status;
    private double totalPrice;
    private PendingClothGroup[]groups;


    public Order(){
        this.orderID = "null";
        this.cloths = new Cloth[25];
        this.numberOfEntries = 0;
        this.status = "unfinished";
        this.totalPrice = 0.0;
    }
    public Order(String orderID) {
        this.orderID=orderID;
        this.cloths=new Cloth[25];;
        this.status="unfinished";
        this.totalPrice=0;
        numberOfEntries = 0;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
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

    public boolean isArrayFull() {
        return numberOfEntries >= cloths.length;
    }
    public boolean isEmpty(){
        return numberOfEntries == 0;
    }
    public int getCurrentSize(){
        return numberOfEntries;
    }
    public int getFrequencyOf(Cloth anEntry) {
        int counter = 0;
        for (int index = 0; index < numberOfEntries; index++) {
            if (anEntry.equals(cloths[index])) {
                counter++;
            } // end if
        } // end for
        return counter;
    }
    public boolean contains(Cloth anEntry) {
        return getIndexOf(anEntry) > -1;
    }
    public boolean add(Cloth newEntry) {
        boolean result = true;
        if (isArrayFull()) {
            result = false;
        } else { // Assertion: result is true here
            cloths[numberOfEntries] = newEntry;
            numberOfEntries++;
        } // end if
        return result;
    }
    private int getIndexOf(Cloth anEntry) {
        int where = -1;
        boolean stillLooking = true;
        int index = 0;
        while ( stillLooking && (index < numberOfEntries)) {
            if (anEntry.equals(cloths[index])) {
                stillLooking = false;
                where = index;
            } // end if
            index++;
        }
        return where;
    }
    public void clear() {
        while (!isEmpty()) {
            remove();
        }
    }
    public boolean remove(Cloth anEntry) {
        int index = getIndexOf(anEntry);
        Cloth result = removeEntry(index);
        return anEntry.equals(result);
    }
    public Cloth remove() {
        Cloth result = removeEntry(numberOfEntries - 1);
        return result;
    }
    private Cloth removeEntry(int givenIndex) {
        Cloth result = null;
        if (!isEmpty() && (givenIndex >= 0)) {
            result = cloths[givenIndex];
            cloths[givenIndex] = cloths[numberOfEntries - 1];
            cloths [numberOfEntries - 1] = null;
            numberOfEntries--;
        } // end if
        return result;
    }
}
