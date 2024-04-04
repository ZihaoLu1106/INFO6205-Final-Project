package com.info6205.algorithm;

public interface BSTInterface<T> {
    boolean isEmpty();

    // Method to get the size of the BST
    int size();

    // Method to insert a new element into the BST
    void insert(T element);

    // Method to remove an element from the BST
    void remove(T element);

    // Method to check if an element is present in the BST
    boolean contains(T element);

    // Method to perform a preorder traversal of the BST
    int preorderTraversal(int i);

}
