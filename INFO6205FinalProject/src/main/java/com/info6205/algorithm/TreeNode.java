package com.info6205.algorithm;

import java.util.ArrayList;
import java.util.List;

public class TreeNode<T> implements TreeInterface<T> {
    private T value;
    private List<TreeInterface<T>> children;

    public TreeNode(T value) {
        this.value = value;
        this.children=new ArrayList<>();
    }

    @Override
    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public List<TreeInterface<T>> getChildren() {
        return children;
    }

    @Override
    public void setChildren(List<TreeInterface<T>> children) {
        this.children=children;
    }

    public void addChildren(TreeNode<T> child){
        children.add(child);
    }


}

