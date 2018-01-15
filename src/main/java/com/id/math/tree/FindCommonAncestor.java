package com.id.math.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindCommonAncestor {


    /**
     * Given n2 nodes that already exist in a binary search tree, findLCA the lowest common ancestor.
     *
     * @param root repesenting BST
     * @param n1
     * @param n2
     * @return node which is common ancestor of both
     */
    //use ints just to ease comparing.
    public static BinaryTreeNode<Integer> findLCAInBST(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> n1, BinaryTreeNode<Integer> n2) {
        // Check if n1 and n2 are in the root tree.
        while (root != null) {
            if (root.data < n1.data && root.data < n2.data) {
                root = root.right;
            } else if (root.data > n1.data && root.data > n2.data) {
                root = root.left;
            } else {
                return root;
            }
        }
        return null;
    }

    /**
     * Given two nodes that already exist in a binary tree, findLCA the lowest common ancestor.
     *
     * @param n1
     * @param n2
     * @return node which is common ancestor of both
     */
    public NodeWithParent findLCA(NodeWithParent n1, NodeWithParent n2) {
        NodeWithParent curr = n1;
        int i = 0;
        while (curr != null) {
            curr = curr.parent;
            i++;
        }

        curr = n2;
        int j = 0;
        while (curr != null) {
            curr = curr.parent;
            j++;
        }

        NodeWithParent lo;//deepest node.
        NodeWithParent hi;
        if (i >= j) {
            lo = n1;
            hi = n2;
        } else {
            lo = n2;
            hi = n1;
        }

        //align both to same level.
        int delta = Math.abs(i - j);
        while (delta > 0) {
            lo = lo.parent;
            delta--;
        }

        while (lo != hi) {
            lo = lo.parent;
            hi = hi.parent;
        }

        return lo;//or hi as they point to common ancestor.
    }

    @Test
    public void test1() {
        NodeWithParent r = new NodeWithParent(0);
        NodeWithParent n1 = new NodeWithParent(1);
        NodeWithParent n2 = new NodeWithParent(2);
        NodeWithParent n3 = new NodeWithParent(3);
        NodeWithParent n4 = new NodeWithParent(4);
        NodeWithParent n5 = new NodeWithParent(5);
        NodeWithParent n6 = new NodeWithParent(6);
        NodeWithParent n7 = new NodeWithParent(7);
        NodeWithParent n8 = new NodeWithParent(8);

        n1.parent = r;
        n2.parent = n1;
        n3.parent = n2;
        n4.parent = n3;
        n5.parent = n4;

        n6.parent = n1;
        n7.parent = n6;
        n8.parent = n7;

        NodeWithParent ca1 = findLCA(r, r);
        assertEquals(r, ca1);

        NodeWithParent ca2 = findLCA(n5, n8);
        assertEquals(n1, ca2);
    }


}
