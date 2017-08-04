package com.xkcoding.legendary.tree;

public class BinaryTreeNodeTraversalTest {
	public static void main(String[] args) {
		BinaryTreeNode left = new BinaryTreeNode(2);
		left.setLeft(new BinaryTreeNode(4));
		left.setRight(new BinaryTreeNode(5));

		BinaryTreeNode right = new BinaryTreeNode(3);
		right.setLeft(new BinaryTreeNode(6));

		BinaryTreeNode root = new BinaryTreeNode(1);
		root.setLeft(left);
		root.setRight(right);

		System.out.print("\n先序遍历: ");
		BinaryTreeNode.nlr(root);
		System.out.print("\n中序遍历: ");
		BinaryTreeNode.lnr(root);
		System.out.print("\n后序遍历: ");
		BinaryTreeNode.lrn(root);
		System.out.print("\n树的节点总数: " + BinaryTreeNode.nodeCount(root));
		System.out.println("\n树的深度: " + BinaryTreeNode.deep(root));
	}
}
