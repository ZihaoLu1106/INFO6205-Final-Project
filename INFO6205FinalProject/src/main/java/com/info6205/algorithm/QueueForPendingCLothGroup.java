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
        if (priority == 0) {
            list.add(element);
        } else if (priority == 1) {
            list.add(0, element);
        } else {
            int insertIndex = findInsertIndex(priority);
            list.add(insertIndex, element);
        }
    }
    private int findInsertIndex(int priority) {
        int insertIndex = 0;
        for (PendingClothGroup e : list) {
            if (getPriority(e) == 1) {
                break;
            }
            insertIndex++;
        }
        return insertIndex;
    }

    private int getPriority(PendingClothGroup element) {
        return list.indexOf(element) == 0 ? 1 : 0;
    }

    @Override
    public PendingClothGroup dequeue() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue is empty");
        }
        return list.remove(0);
    }

    @Override
    public PendingClothGroup peek() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue is empty");
        }
        return list.get(0);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void clear() {
        list.clear();
    }
}
