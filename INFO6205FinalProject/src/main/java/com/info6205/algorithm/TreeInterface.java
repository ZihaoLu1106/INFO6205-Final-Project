package com.info6205.algorithm;

import java.util.List;

public interface TreeInterface<T> {
    T getValue();
    void setValue(T value);
    List<T>getChildren();
    void setChildren(List<T>children);
}
