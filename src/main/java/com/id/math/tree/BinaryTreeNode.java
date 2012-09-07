package com.id.math.tree;

public class BinaryTreeNode<T> {

	BinaryTreeNode left;
	BinaryTreeNode right;
	BinaryTreeNode parent;
	T value;

	public BinaryTreeNode(T v) {
		value = v;
	}

}
