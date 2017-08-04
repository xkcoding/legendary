package com.xkcoding.legendary.tree;

/**
 * 二叉树
 *
 * @author Yangkai.Shen
 * @version 1.0
 * @date 2017.08.03 at 02:22:19
 */
public class BinaryTreeNode {
	private Integer root;
	private BinaryTreeNode left;
	private BinaryTreeNode right;

	public BinaryTreeNode(Integer root) {
		this.root = root;
	}

	public static int nodeCount(BinaryTreeNode tree) {
		if (tree == null) {
			return 0;
		}
		return nodeCount(tree.left) + nodeCount(tree.right) + 1;
	}

	public static int deep(BinaryTreeNode tree) {
		if (tree == null) {
			return 0;
		}
		return (deep(tree.left) + 1) > (deep(tree.right) + 1) ? (deep(tree.left) + 1) : (deep(tree.right) + 1);
	}

	/**
	 * 中序遍历
	 *
	 * @param tree 二叉树
	 */
	public static void lnr(BinaryTreeNode tree) {
		if (tree == null) {
			return;
		}

		lnr(tree.getLeft());
		System.out.print(tree.getRoot() + " ");
		lnr(tree.getRight());
	}

	/**
	 * 后序遍历
	 *
	 * @param tree 二叉树
	 */
	public static void lrn(BinaryTreeNode tree) {
		if (tree == null) {
			return;
		}

		lrn(tree.getLeft());
		lrn(tree.getRight());
		System.out.print(tree.getRoot() + " ");
	}

	/**
	 * 先序遍历
	 *
	 * @param tree 二叉树
	 */
	public static void nlr(BinaryTreeNode tree) {
		if (tree == null) {
			return;
		}

		System.out.print(tree.getRoot() + " ");
		nlr(tree.getLeft());
		nlr(tree.getRight());
	}

	public BinaryTreeNode getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}

	public BinaryTreeNode getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}

	public Integer getRoot() {
		return root;
	}

	public void setRoot(Integer root) {
		this.root = root;
	}
}
