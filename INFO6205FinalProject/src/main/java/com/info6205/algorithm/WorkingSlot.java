package com.info6205.algorithm;

public class WorkingSlot {
    private int id;
    private int remainTime;
    private String status;//"Empty";"Processing";"finished"

    private PendingClothGroup group;

    public PendingClothGroup getGroup() {
        return group;
    }

    public void setGroup(PendingClothGroup group) {
        this.group = group;
    }

    public WorkingSlot(int id){
        this.id=id;
        this.remainTime=0;
        this.status="Empty";
        group=null;
    }
    public WorkingSlot(){
        this.status="Empty";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRemainTime() {
        return remainTime;
    }

    public void setRemainTime(int remainTime) {
        this.remainTime = remainTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public boolean isEmpty(){
        if(this.status.equals("Empty"))
            return true;
        return false;

    }

}
