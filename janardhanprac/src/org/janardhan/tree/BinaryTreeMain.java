package org.janardhan.tree;

import java.util.Scanner;

public class BinaryTreeMain {

	public static void main(String[] args) {

		BinaryTree binaryTree = new BinaryTree();

		binaryTree.treeNode = new TreeNode(1);
		binaryTree.treeNode.leftNode = new TreeNode(2);
		binaryTree.treeNode.rightNode = new TreeNode(3);
		binaryTree.treeNode.leftNode.leftNode = new TreeNode(4);
		binaryTree.treeNode.leftNode.rightNode = new TreeNode(5);

		System.out.println("Choose any of the below Binary Tree Operations");
		System.out.println("1. inorder traversal ");
		System.out.println("2. inorder iterative traversal");
		System.out.println("3. preorder traversal");
		System.out.println("4. preorder iterative traversal");
		System.out.println("5. postorder traversal");
		System.out.println("6. postorder iterative traversal using two stacks");
		System.out.println("7. postorder iterative traversal using single stack");
		System.out.println("8. levelorder traversal");
		System.out.println("9. levelorder traversal using queue");
		System.out.println("10. diameter/width of a tree");
		System.out.println("11. height of tree");
		System.out.println("12. clone binary tree");
		System.out.println("13. lca between nodes");

		Scanner scanner = new Scanner(System.in);
		String choice = scanner.nextLine();

		switch (choice.toLowerCase()) {

		case "inorder traversal":
			System.out.print("Inorder Traversal >>> ");
			binaryTree.printInOrder(binaryTree.treeNode);
			break;

		case "inorder iterative traversal":
			System.out.print("\n" + "Inorder Iterative Traversal >>> ");
			binaryTree.printInOrderIterative(binaryTree.treeNode);
			break;

		case "preorder traversal":
			System.out.print("\n" + "PreOrder Traversal >>> ");
			binaryTree.printPreOrder(binaryTree.treeNode);
			break;

		case "preorder iterative traversal":
			System.out.print("\n" + "PreOrder Iterative Traversal >>> ");
			binaryTree.printPreOrderIterative(binaryTree.treeNode);
			break;

		case "postorder traversal":
			System.out.print("\n" + "Post Order Traversal >>> ");
			binaryTree.printPostOrder(binaryTree.treeNode);
			break;

		case "postorder iterative traversal using two stacks":
			System.out.print("\n" + "Post Order Iterative Traversal Using Two Stacks >>> ");
			binaryTree.printPostOrderIterativeUsingTwoStacks(binaryTree.treeNode);
			break;

		case "postorder iterative traversal using single stack":
			System.out.print("\n" + "Post Order Iterative Traversal Using One Stacks >>> ");
			binaryTree.printPostOrderIterativeUsingOneStacks(binaryTree.treeNode);
			break;

		case "levelorder traversal":
			System.out.print("\n" + "Level Order Tree Traversal >>> ");
			binaryTree.printLevelOrderTreeTraversal(binaryTree.treeNode);
			break;

		case "levelorder traversal using queue":
			System.out.print("\n" + "Level Order Tree Traversal Using Queue >>> ");
			binaryTree.printLevelOrderTreeTraversalUsingQueue(binaryTree.treeNode);
			break;

		case "diameter/width of a tree":
			System.out.print("\n" + "Diameter or Width of a binary tree >>> "
					+ binaryTree.printDiameterOfBinaryTree(binaryTree.treeNode));
			break;

		case "height of tree":
			System.out.println(
					"\n" + "Height or Max Depth of the tree >>> " + binaryTree.printHeightTree(binaryTree.treeNode));
			break;

		case "clone binary tree":
			System.out.println("\n Copy of the binary tree >> ");
			binaryTree.printInOrder(binaryTree.cloneBinaryTree(binaryTree.treeNode));
			break;

		case "lca between nodes":
			System.out.print("Lowest Common Ancestor between two nodes in a binary Tree  ");
			System.out.print(binaryTree.getLCABetweenTwoNodes(binaryTree.treeNode, 4, 5).data);
			break;

		default:
			throw new IllegalArgumentException("are bawli booch ");
		}

		scanner.close();
	}
}
