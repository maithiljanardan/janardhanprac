package org.janardhan.tree;

import org.omg.CosNaming.IstringHelper;

public class BSTMain {

	public static void main(String[] args) {

		BinarySearchTree binaryST = new BinarySearchTree();

		// Creating a new BST
		binaryST.treeNode = new TreeNode(8);
		binaryST.treeNode.leftNode = new TreeNode(3);
		binaryST.treeNode.rightNode = new TreeNode(10);
		binaryST.treeNode.leftNode.leftNode = new TreeNode(1);
		binaryST.treeNode.leftNode.rightNode = new TreeNode(6);
		binaryST.treeNode.leftNode.rightNode.leftNode = new TreeNode(4);
		binaryST.treeNode.leftNode.rightNode.rightNode = new TreeNode(7);
		binaryST.treeNode.rightNode.rightNode = new TreeNode(14);
		binaryST.treeNode.rightNode.rightNode.leftNode = new TreeNode(13);

		// Method to search a node in BST
		TreeNode searchSearched = binaryST.searchNode(binaryST.treeNode, 14);
		if (searchSearched != null)
			System.out.println("Node Found");
		else
			System.out.println("Node not present");

		// Inserting a new node in BST
		TreeNode newNode = new TreeNode(12);
		binaryST.treeNode = binaryST.insertNewNodeInBST(binaryST.treeNode, newNode);

		System.out.println("BST after insertion of a new node in inorder traversal");
		binaryST.printInOrder(binaryST.treeNode);

		// Delete a node in BST
		// binaryST.treeNode = binaryST.deleteNodeInBST(binaryST.treeNode, 6);
		// System.out.println("\n" + "BST after deleting a node in inorder
		// traversal");
		// binaryST.printInOrder(binaryST.treeNode);

		System.out.println("\n" + "Inorder Predecessor and Successor of a node in BST");
		binaryST.printInorderPreAndSuc(binaryST.treeNode, 6);

		if (binaryST.isTreeBST(binaryST.treeNode, Integer.MIN_VALUE, Integer.MAX_VALUE))
			System.out.println("Tree is a BST");
		else
			System.out.println("Tree is not a BST");

	}
}
