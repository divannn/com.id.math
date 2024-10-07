package com.id.math.tree;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreeWidth {

    /**
     * Finds width of three - max number of nodes in any horizontal layer.
     *
     * @return width of three
     */
    private <T> int treeWidth(BinaryTreeNode<T> root) {
        if (root == null) {
            return 0;
        }
        int result = 1;
        Queue<BinaryTreeNode<T>> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            BinaryTreeNode<T> curr = q.poll();
            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
            result = Math.max(result, q.size());
        }
        return result;
    }

    @Test
    public void test1() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(111);
        BinaryTreeNode<Integer> n2 = new BinaryTreeNode<>(222);
        BinaryTreeNode<Integer> n3 = new BinaryTreeNode<>(333);
        BinaryTreeNode<Integer> n4 = new BinaryTreeNode<>(444);
        BinaryTreeNode<Integer> n5 = new BinaryTreeNode<>(555);
        BinaryTreeNode<Integer> n6 = new BinaryTreeNode<>(666);
        BinaryTreeNode<Integer> n7 = new BinaryTreeNode<>(777);

        root.left = n2;
        root.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.right = n6;
        n6.left = n7;

        assertEquals(1, treeWidth(n7));
        assertEquals(1, treeWidth(n3));
        assertEquals(2, treeWidth(n2));
        assertEquals(3, treeWidth(root));
    }

}