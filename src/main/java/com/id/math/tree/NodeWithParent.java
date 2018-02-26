package com.id.math.tree;

public class NodeWithParent<T> extends BinaryTreeNode<T> {
    NodeWithParent<T> parent;

    public NodeWithParent(NodeWithParent<T> parent,T v) {
        super(v);
        this.parent = parent;
    }
}
