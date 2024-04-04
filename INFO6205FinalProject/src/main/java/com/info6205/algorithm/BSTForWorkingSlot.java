package com.info6205.algorithm;

public class BSTForWorkingSlot implements BSTInterface<WorkingSlot>{

    private static BSTForWorkingSlot instance;
    private WorkingSlot[] slots;

    private BSTForWorkingSlot(){
        //initailize
        slots=new WorkingSlot[15];
        for(int i=0;i<=6;i++){
            WorkingSlot emptySlot=new WorkingSlot();
            slots[i]=emptySlot;
        }
        for(int i=7;i<slots.length;i++){
            WorkingSlot slot=new WorkingSlot(i-6);
            slots[i]=slot;
        }
    }
    public static BSTForWorkingSlot getInstance() {
        // If instance is null, create a new instance
        if (instance == null) {
            instance = new BSTForWorkingSlot();
        }
        // Return the instance
        return instance;
    }

    public WorkingSlot findEmptySlot(){
        //check if there is empty slot left
        if(!slots[0].isEmpty())
            return null;
        int slotIndex=preorderTraversal(0);
        if(slotIndex>0)
            return slots[slotIndex];
        else{
            System.out.println("error");
            return null;
        }
    }
    public void useSlot(int id){
        int index=id+6;
        slots[index].setStatus("Processing");
        checkstatus(index);
    }
    public WorkingSlot getWorkingSlot(int id){
        return slots[id+6];
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void insert(WorkingSlot element) {

    }

    @Override
    public void remove(WorkingSlot element) {

    }

    @Override
    public boolean contains(WorkingSlot element) {
        return false;
    }

    @Override
    public int preorderTraversal(int i) {
        if (i*2+1> slots.length-1)
            return i;
        int left=i*2+1;
        int right=i*2+2;
        if(slots[left].isEmpty()){
            return preorderTraversal(left);
        }
        if(slots[right].isEmpty()){
            return preorderTraversal(right);
        }
        return 0;
    }
    public void checkstatus(int i){
        if(i==0){
            return;
        }
        //if it is in right side
        if(i%2==0){
            if(!slots[i-1].isEmpty()) {
                slots[(i / 2) - 1].setStatus("Processing");
                checkstatus((i / 2) - 1);
            }
        }
        //if it is in left side
        if(i%2!=0){
            if(!slots[i+1].isEmpty()) {
                slots[(i-1)/2].setStatus("Processing");
                checkstatus((i-1)/2);
            }
        }
    }
}
