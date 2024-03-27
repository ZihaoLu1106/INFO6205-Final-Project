package com.info6205.algorithm;

import java.util.List;

public class admin {

    //singleton
    private static admin instance;
    public static admin getInstance() {
        // If instance is null, create a new instance
        if (instance == null) {
            instance = new admin();
        }
        // Return the instance
        return instance;
    }
    private List<Order>orderList;
    private List<Order>historyOrders;
    private TreeToCategorizeCloth cateegorizedTree;

    private QueueForPendingCLothGroup queue;

    private BSTForWorkingSlot bst;


    public admin(){


    }


}
