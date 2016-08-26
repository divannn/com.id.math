package com.id.math.tree;

import org.junit.Assert;
import org.junit.Test;

public class IsSameTreeCheck {

    /**
     * Algorithm: DFS
     * 1- We will recursively traverse the trees. Our stopping condition is when at least one of them is NULL.
     * 2- If they are both NULL, it means we have successfully finished the traversal and the trees are the identical.
     * 3- If one is NULL and the other is not, then the trees are structurally different and we need to return false.
     * 4- If they are both not empty, we compare the values and recurse for both left and right children if the values are equal.
     *
     * Time complexity: O(min(N, M)), where N and M are the number of nodes for the trees. At the worst case, we will process all the nodes in the smaller tree.
     * @param p - tree 1
     * @param q - tree 2
     * @return true if trees are equal
     */
    public boolean isSameTree(BinaryTreeNode p, BinaryTreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q != null && p.data == q.data) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }


//    @Test
//    public void test1() {
//        BinaryTreeNode<Integer> t1 = createTree();
//        BinaryTreeNode<Integer> t2 = createTree();
//        Assert.assertTrue(isSameTree(t1, t2));
//    }

    @Test
    public void test2() {
        BinaryTreeNode<Integer> t1 = createTree();
        BinaryTreeNode<Integer> t2 = createTree2();
        Assert.assertTrue(isSameTree(t1, t2));
    }


    private static BinaryTreeNode<Integer> createTree() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> n2 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> n3 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> n4 = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> n5 = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> n6 = new BinaryTreeNode<>(6);

        root.left = n2;
        root.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;
        return root;
    }

    private static BinaryTreeNode<Integer> createTree2() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> n2 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> n3 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> n4 = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> n5 = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> n6 = new BinaryTreeNode<>(6);
        BinaryTreeNode<Integer> n7 = new BinaryTreeNode<>(7);

        root.left = n2;
        root.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;
        n3.right = n7;
        return root;
    }
}
