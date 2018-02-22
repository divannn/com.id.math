package com.id.math.tree;

public class BinaryTreeNode<T> {

    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;
    T data;

    public BinaryTreeNode(T v) {
        data = v;
    }

    @Override
    public String toString() {
        return data.toString();
    }

}
