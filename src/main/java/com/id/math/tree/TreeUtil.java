package com.id.math.tree;

public final class TreeUtil {

    public static <T> NodeWithParent<T> findParent(NodeWithParent<T> n) {
        NodeWithParent<T> curr = n;
        while (curr != null) {
            curr = curr.parent;
        }
        return curr;
    }

}
