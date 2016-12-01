package org.janardhan.tree;

import java.util.Stack;

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

	public void printPreOrderIterative(TreeNode treeNode) {

		Stack<TreeNode> stack = new Stack<TreeNode>();

		stack.push(treeNode);

		while (!stack.isEmpty()) {

			TreeNode poppedNode = stack.pop();

			System.out.print(poppedNode.data + " ");

			if (poppedNode.rightNode != null)
				stack.push(poppedNode.rightNode);
			if (poppedNode.leftNode != null)
				stack.push(poppedNode.leftNode);

		}
	}

	public void printInOrder(TreeNode treeNode) {

		if (treeNode == null)
			return;

		printInOrder(treeNode.leftNode);

		System.out.print(treeNode.data + " ");

		printInOrder(treeNode.rightNode);
	}

	public void printInOrderIterative(TreeNode treeNode) {

		Stack<TreeNode> stack = new Stack<TreeNode>();

		boolean pushFlag = true;

		TreeNode currentNode = treeNode;

		while (pushFlag) {

			if (currentNode != null) {
				stack.push(currentNode);
				currentNode = currentNode.leftNode;
			} else {

				if (stack.empty()) {
					pushFlag = false;
				} else {
					currentNode = stack.pop();
					System.out.print(currentNode.data + " ");
					currentNode = currentNode.rightNode;
				}

			}
		}

	}

	public void printPostOrder(TreeNode treeNode) {

		if (treeNode == null)
			return;

		printPostOrder(treeNode.leftNode);

		printPostOrder(treeNode.rightNode);

		System.out.print(treeNode.data + " ");
	}

	public void printPostOrderIterativeUsingTwoStacks(TreeNode treeNode) {

		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();

		stack1.push(treeNode);

		while (!stack1.isEmpty()) {

			TreeNode poppedNode = stack1.pop();
			stack2.push(poppedNode);

			if (poppedNode.leftNode != null)
				stack1.push(poppedNode.leftNode);
			if (poppedNode.rightNode != null)
				stack1.push(poppedNode.rightNode);

		}
		while (!stack2.isEmpty()) {
			System.out.print(stack2.pop().data + " ");
		}
	}

}