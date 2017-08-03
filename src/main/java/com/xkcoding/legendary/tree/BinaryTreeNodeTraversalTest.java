package com.xkcoding.legendary.tree;

public class BinaryTreeNodeTraversalTest {
	public static void main(String[] args) {
		BinaryTreeNode binaryTreeNode = new BinaryTreeNode(1);
		binaryTreeNode.setLeft(new BinaryTreeNode(2));
		binaryTreeNode.setRight(new BinaryTreeNode(3));

		System.out.print("\n先序遍历: ");
		BinaryTreeNode.nlr(binaryTreeNode);
		System.out.print("\n中序遍历: ");
		BinaryTreeNode.lnr(binaryTreeNode);
		System.out.print("\n后序遍历: ");
		BinaryTreeNode.lrn(binaryTreeNode);
	}
}
