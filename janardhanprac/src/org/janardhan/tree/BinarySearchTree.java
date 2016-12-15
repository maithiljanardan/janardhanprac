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
}
