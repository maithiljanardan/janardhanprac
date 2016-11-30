package org.janardhan.tree;

public class BinaryTreeMain {

	public static void main(String[] args) {

		BinaryTree binaryTree = new BinaryTree();

		binaryTree.treeNode = new TreeNode(1);
		binaryTree.treeNode.leftNode = new TreeNode(2);
		binaryTree.treeNode.rightNode = new TreeNode(3);
		binaryTree.treeNode.leftNode.leftNode = new TreeNode(4);
		binaryTree.treeNode.leftNode.rightNode = new TreeNode(5);

		System.out.print("Inorder Traversal >>> ");
		binaryTree.printInOrder(binaryTree.treeNode);
		
		System.out.print("\n" + "Inorder Iterative Traversal >>> ");
		binaryTree.printInOrderIterative(binaryTree.treeNode);

		System.out.print("\n" + "PreOrder Traversal >>> ");
		binaryTree.printPreOrder(binaryTree.treeNode);

		System.out.print("\n" + "PreOrder Iterative Traversal >>> ");
		binaryTree.printPreOrderIterative(binaryTree.treeNode);

		System.out.print("\n" + "Post Order Traversal >>> ");
		binaryTree.printPostOrder(binaryTree.treeNode);

	}
}
