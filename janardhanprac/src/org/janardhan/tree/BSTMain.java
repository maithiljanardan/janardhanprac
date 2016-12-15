package org.janardhan.tree;

public class BSTMain {

	public static void main(String[] args) {

		BinarySearchTree binaryST = new BinarySearchTree();

		binaryST.treeNode = new TreeNode(8);
		binaryST.treeNode.leftNode = new TreeNode(3);
		binaryST.treeNode.rightNode = new TreeNode(10);
		binaryST.treeNode.leftNode.leftNode = new TreeNode(1);
		binaryST.treeNode.leftNode.rightNode = new TreeNode(6);
		binaryST.treeNode.leftNode.rightNode.leftNode = new TreeNode(4);
		binaryST.treeNode.leftNode.rightNode.rightNode = new TreeNode(7);
		binaryST.treeNode.rightNode.rightNode = new TreeNode(14);
		binaryST.treeNode.rightNode.rightNode.leftNode = new TreeNode(13);

		TreeNode nodeSearch = new TreeNode(89);
		TreeNode searchSearched = binaryST.searchNode(binaryST.treeNode, nodeSearch.data);
		if (searchSearched != null)
			System.out.println("Node Found");
		else
			System.out.println("Node not present");
	}
}
