package com.info6205.algorithm;

import java.util.ArrayList;
import java.util.List;

public class Admin {

    //singleton
    private static Admin instance;
    public static Admin getInstance() {
        // If instance is null, create a new instance
        if (instance == null) {
            instance = new Admin();
        }

        // Return the instance
        return instance;
    }
    private List<Order>orderList;
    private List<Order>historyOrders;
    private TreeToCategorizeCloth categorizedTree;

    private QueueForPendingCLothGroup queue;

    private BSTForWorkingSlot bst;


    public Admin(){
        orderList=new ArrayList<>();
        historyOrders=new ArrayList<>();
        categorizedTree=new TreeToCategorizeCloth();
        queue=new QueueForPendingCLothGroup<PendingClothGroup>();
        bst=BSTForWorkingSlot.getInstance();

    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public List<Order> getHistoryOrders() {
        return historyOrders;
    }

    public TreeToCategorizeCloth getCategorizedTree() {
        return categorizedTree;
    }

    public QueueForPendingCLothGroup getQueue() {
        return queue;
    }

    public BSTForWorkingSlot getBst() {
        return bst;
    }
}
