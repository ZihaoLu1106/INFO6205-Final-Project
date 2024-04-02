package com.info6205.algorithm;

import java.util.NoSuchElementException;

public interface PriorityQueueInterface <E>{

    /**
     * Adds an element to the priority queue with the specified priority.
     *
     * @param element  the element to be added
     * @param priority the priority of the element
     */
    void enqueue(E element, int priority);

    /**
     * Removes and returns the element with the highest priority.
     *
     * @return the element with the highest priority
     * @throws NoSuchElementException if the priority queue is empty
     */
    E dequeue() throws NoSuchElementException;

    /**
     * Returns the element with the highest priority without removing it from the queue.
     *
     * @return the element with the highest priority
     * @throws NoSuchElementException if the priority queue is empty
     */
    E peek() throws NoSuchElementException;

    /**
     * Returns true if the priority queue is empty, false otherwise.
     *
     * @return true if the priority queue is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in the priority queue.
     *
     * @return the number of elements in the priority queue
     */
    int size();

    /**
     * Removes all elements from the priority queue.
     */
    void clear();

}
