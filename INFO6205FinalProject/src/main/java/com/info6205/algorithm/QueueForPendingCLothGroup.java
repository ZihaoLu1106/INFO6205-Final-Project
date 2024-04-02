package com.info6205.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class QueueForPendingCLothGroup<E> implements PriorityQueueInterface<PendingClothGroup> {

    private List<PendingClothGroup> list;

    public List<PendingClothGroup> getList() {
        return list;
    }

    public QueueForPendingCLothGroup(){
        list=new ArrayList<>();
    }
    @Override
    public void enqueue(PendingClothGroup  element, int priority) {
        list.add(element);
    }

    @Override
    public PendingClothGroup dequeue() throws NoSuchElementException {
        return null;
    }

    @Override
    public PendingClothGroup peek() throws NoSuchElementException {
        return null;
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
    public void clear() {

    }
}
