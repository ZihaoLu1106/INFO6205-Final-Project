package com.info6205.algorithm;

import java.util.List;

public interface TreeInterface<T> {
    T getValue();
    void setValue(T value);
    List<TreeInterface<T>>getChildren();
    void setChildren(List<TreeInterface<T>>children);
}
