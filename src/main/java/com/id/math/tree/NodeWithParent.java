package com.id.math.tree;

public class NodeWithParent<T> extends BinaryTreeNode<T> {
    NodeWithParent<T> parent;

    public NodeWithParent(T v) {
        super(v);
    }
}
