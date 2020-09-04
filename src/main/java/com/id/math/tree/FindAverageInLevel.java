package com.id.math.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


/**
 * Given a binary tree of integers find average value for each tree level.
 * Example:
 * 4
 * /   \
 * 7     9
 * Output: [4,8]
 *
 * @company facebook
 */
public class FindAverageInLevel {

    /**
     * Algorithm: DFS
     *
     * @param root - root of tree
     * @return true if tree is valid binaray search tree
     * @complexity O(n)
     * @space O(n) (recursion)
     */
    public List<Integer> findAverageInLevel(BinaryTreeNode<Integer> root) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        collect(root, map, 0);
        List<Integer> result = new ArrayList<>();
        for (Integer level : map.keySet()) {
            List<Integer> levelData = map.get(level);
            int levelAvg = levelData.stream().mapToInt(Integer::intValue).sum() / levelData.size();
            result.add(levelAvg);
        }
        return result;
    }

    private void collect(BinaryTreeNode<Integer> root, HashMap<Integer, List<Integer>> map, int level) {
        if (root == null) {
            return;
        }
        List<Integer> levelData = map.computeIfAbsent(level, k -> new ArrayList<>());
        levelData.add(root.data);
        collect(root.left, map, level + 1);
        collect(root.right, map, level + 1);
    }

    @Test
    public void testEqual() {
        Assert.assertEquals(Arrays.asList(44, 38, 36), findAverageInLevel(createTree()));
        Assert.assertEquals(Arrays.asList(3, 3, 2), findAverageInLevel(createTree2()));
    }

    private static BinaryTreeNode<Integer> createTree() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(44);
        BinaryTreeNode<Integer> n2 = new BinaryTreeNode<>(22);
        BinaryTreeNode<Integer> n3 = new BinaryTreeNode<>(55);
        BinaryTreeNode<Integer> n4 = new BinaryTreeNode<>(11);
        BinaryTreeNode<Integer> n5 = new BinaryTreeNode<>(33);
        BinaryTreeNode<Integer> n6 = new BinaryTreeNode<>(66);

        root.left = n2;
        root.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.right = n6;
        return root;
    }

    private static BinaryTreeNode<Integer> createTree2() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> n2 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> n3 = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> n4 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> n5 = new BinaryTreeNode<>(4);

        root.left = n2;
        root.right = n3;

        n2.left = n4;
        n3.right = n5;

        return root;
    }

}