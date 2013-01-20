package com.id.math.tree;

public final class TreeUtil {

    public static <T> NodeWithParent<T> findParent(NodeWithParent<T> n) {
        NodeWithParent<T> curr = n;
        while (curr != null) {
            curr = curr.parent;
        }
        return curr;
    }

    public static int depth(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return 1 + Math.max(depth(root.left), depth(root.right));
    }

}
