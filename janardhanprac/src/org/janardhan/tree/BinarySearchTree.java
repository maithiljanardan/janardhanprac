package org.janardhan.tree;

public class BinarySearchTree {

	TreeNode treeNode;

	public BinarySearchTree() {
		this.treeNode = treeNode;
	}

	public TreeNode searchNode(TreeNode treeNode, int key) {

		if (treeNode == null || treeNode.data == key)
			return treeNode;
		if (key < treeNode.data)
			return searchNode(treeNode.leftNode, key);
		return searchNode(treeNode.rightNode, key);

	}

	/**
	 * @author jd
	 * @param treeNode
	 * @param newNode
	 * @return
	 * 
	 * 		This method insert a new Node into a BST. The idea is to search a
	 *         key from root till we find a leaf node and depending on data new
	 *         node is added to it.
	 */
	public TreeNode insertNewNodeInBST(TreeNode treeNode, TreeNode newNode) {

		if (treeNode == null) {
			treeNode = newNode;
			return treeNode;
		}

		if (newNode.data > treeNode.data)
			treeNode.rightNode = insertNewNodeInBST(treeNode.rightNode, newNode);
		else if (newNode.data < treeNode.data)
			treeNode.leftNode = insertNewNodeInBST(treeNode.leftNode, newNode);
		return treeNode;
	}

	public void printInOrder(TreeNode treeNode) {

		if (treeNode == null)
			return;

		printInOrder(treeNode.leftNode);

		System.out.print(treeNode.data + " ");

		printInOrder(treeNode.rightNode);
	}
}
