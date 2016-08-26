package com.id.math.tree;

import java.util.LinkedList;

public class TreeSearch {

    /**
     * Search in binary search tree.
     *
     * @param root
     * @param target
     * @return
     */
    //use ints just to ease comparing.
    public static boolean binarySearch(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> target) {
        BinaryTreeNode<Integer> current = root;
        while (current != null) {
            if (current.data > target.data) {
                current = current.left;
            } else if (current.data < target.data) {
                current = current.right;
            } else {
                return true;
            }
        }
        return false;
    }

    public static <T> boolean dfs(BinaryTreeNode<T> root, T target) {
        if (root == null) {
            return false;
        }
        if (target.equals(root.data)) {
            return true;
        }
        return dfs(root.left, target) || dfs(root.right, target);
    }

    public static <T> boolean bfs(BinaryTreeNode<T> root, T target) {
        if (root == null) {
            return false;
        }
        LinkedList<BinaryTreeNode> list = new LinkedList<BinaryTreeNode>();
        list.add(root);
        BinaryTreeNode<Integer> current;
        while (list.size() > 0) {
            current = list.remove();
            if (target.equals(current.data)) {
                return true;
            }
            if (current.left != null) {
                list.add(current.left);
            }
            if (current.right != null) {
                list.add(current.right);
            }
        }
        return false;
    }

}