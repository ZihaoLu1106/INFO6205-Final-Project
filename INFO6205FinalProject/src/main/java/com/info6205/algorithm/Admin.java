package com.info6205.algorithm;

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
    private TreeToCategorizeCloth cateegorizedTree;

    private QueueForPendingCLothGroup queue;

    private BSTForWorkingSlot bst;


    public Admin(){


    }


}
