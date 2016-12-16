package org.janardhan.tree;

public class BinarySearchTree {

	TreeNode treeNode;

	public BinarySearchTree() {

	}

	/**
	 * @author jd
	 * @param treeNode
	 * @param key
	 * @return {@link TreeNode}
	 * 
	 */
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

	/**
	 * @author jd
	 * @param treeNode
	 * @return
	 * 
	 * 		The important thing to note is, inorder successor is needed only
	 *         when right child is not empty. In this particular case, inorder
	 *         successor can be obtained by finding the minimum value in right
	 *         child of the node.
	 */
	public TreeNode deleteNodeInBST(TreeNode treeNode, int key) {

		if (treeNode == null)
			return treeNode;
		if (key < treeNode.data)
			treeNode.leftNode = deleteNodeInBST(treeNode.leftNode, key);
		else if (key > treeNode.data)
			treeNode.rightNode = deleteNodeInBST(treeNode.rightNode, key);
		else {

			if (treeNode.leftNode == null)
				return treeNode.rightNode;
			else if (treeNode.rightNode == null)
				return treeNode.leftNode;

			treeNode.data = minValue(treeNode.rightNode);
			treeNode.rightNode = deleteNodeInBST(treeNode.rightNode, treeNode.data);
		}
		return treeNode;
	}

	private int minValue(TreeNode treeNode) {

		int minv = treeNode.data;
		while (treeNode.leftNode != null) {
			minv = treeNode.leftNode.data;
			treeNode = treeNode.leftNode;
		}
		return minv;
	}
}
