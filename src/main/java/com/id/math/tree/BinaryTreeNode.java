package com.id.math.tree;

public class BinaryTreeNode<T> {

	BinaryTreeNode left;
	BinaryTreeNode right;
	BinaryTreeNode parent;
	T data;

	public BinaryTreeNode(T v) {
		data = v;
	}

}
