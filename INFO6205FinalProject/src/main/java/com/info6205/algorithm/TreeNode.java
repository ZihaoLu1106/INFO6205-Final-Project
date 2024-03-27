package com.info6205.algorithm;

import java.util.ArrayList;
import java.util.List;

public class TreeNode<T> implements TreeInterface<T> {
    private T value;
    private List<T>children;

    public TreeNode(T value) {
        this.value = value;
        this.children=new ArrayList<T>();
    }

    @Override
    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public List<T> getChildren() {
        return children;
    }

    @Override
    public void setChildren(List<T> children) {
        this.children=children;
    }


}
