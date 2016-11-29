package org.janardhan.tree;

/**
 * @author jd
 *
 */
public class BinaryTree {

	TreeNode treeNode;

	public BinaryTree() {
		treeNode = null;
	}

	public void printPreOrder(TreeNode treeNode) {

		if (treeNode == null)
			return;

		System.out.print(treeNode.data + " ");

		printPreOrder(treeNode.leftNode);

		printPreOrder(treeNode.rightNode);

	}

	public void printInOrder(TreeNode treeNode) {

		if (treeNode == null)
			return;

		printInOrder(treeNode.leftNode);

		System.out.print(treeNode.data + " ");

		printInOrder(treeNode.rightNode);
	}

	public void printPostOrder(TreeNode treeNode) {

		if (treeNode == null)
			return;

		printPostOrder(treeNode.leftNode);

		printPostOrder(treeNode.rightNode);

		System.out.print(treeNode.data + " ");
	}
}
