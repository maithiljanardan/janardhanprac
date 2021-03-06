package org.janardhan.tree;

import java.util.LinkedList;
import java.util.Queue;
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

	/**
	 * 
	 * @author maithiljanardan
	 * @param treeNode
	 * 
	 *            This method prints Inorder Pattern of traversal (LDR)
	 */
	public void printInOrder(TreeNode treeNode) {

		if (treeNode == null)
			return;

		printInOrder(treeNode.leftNode);

		System.out.print(treeNode.data + " ");

		printInOrder(treeNode.rightNode);
	}

	/**
	 * @author maithiljanardan
	 * @param treeNode
	 * 
	 *            This method demonstrate iterative in order traversal using
	 *            stack
	 * 
	 */
	public void printInOrderIterative(TreeNode treeNode) {

		Stack<TreeNode> stack = new Stack<TreeNode>();

		boolean pushFlag = true;

		TreeNode currentNode = treeNode;

		while (pushFlag) {

			// Keep pushing left nodes till leaf node is reached
			if (currentNode != null) {
				stack.push(currentNode);
				currentNode = currentNode.leftNode;
			}

			// Stack will have root at the bottom of the stack . Idea is to pop
			// one element print it and then push its right
			// Once the stack is empty exit the while loop
			else {

				if (stack.empty()) {
					pushFlag = false;
				}
				else {
					currentNode = stack.pop();
					System.out.print(currentNode.data + " ");
					currentNode = currentNode.rightNode;
				}

			}
		}

	}

	/**
	 * Function to traverse binary tree without recursion and without stack
	 */
	public void MorrisTraversalForInorderTraversal(TreeNode root) {

		TreeNode currentNode, preNode;

		if (root == null)
			return;

		currentNode = root;

		while (currentNode != null) {

			if (currentNode.leftNode == null) {

				System.out.print(currentNode.data + " ");
				currentNode = currentNode.rightNode;
			}

			else {

				/* Find the inorder predecessor of current */
				preNode = currentNode.leftNode;

				while (preNode.rightNode != null && preNode.rightNode != currentNode)
					preNode = preNode.rightNode;

				/* Make current as right child of its inorder predecessor */
				if (preNode.rightNode == null) {
					preNode.rightNode = currentNode;
					currentNode = currentNode.leftNode;
				}

				/*
				 * Revert the changes made in if part to restore the original
				 * tree i.e.,fix the right child of predecssor
				 */
				else {
					preNode.rightNode = null;
					System.out.print(currentNode.data + " ");
					currentNode = currentNode.rightNode;
				} /* End of if condition pre->right == NULL */

			} /* End of if condition current->left == NULL */

		} /* End of while */

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

	public void printPostOrderIterativeUsingOneStacks(TreeNode treeNode) {

		Stack<TreeNode> stack = new Stack<TreeNode>();

		stack.push(treeNode);

		TreeNode prevNode = null;

		while (!stack.isEmpty()) {

			TreeNode currentNode = stack.peek();

			if (prevNode == null || prevNode.leftNode == currentNode || prevNode.rightNode == currentNode) {
				if (currentNode.leftNode != null) {
					stack.push(currentNode.leftNode);
				}
				else if (currentNode.rightNode != null) {
					stack.push(currentNode.rightNode);
				}
				else {
					System.out.print(stack.pop().data + " ");

				}
			}
			else if (currentNode.leftNode == prevNode) {
				if (currentNode.rightNode != null) {
					stack.push(currentNode.rightNode);
				}
				else {
					System.out.print(stack.pop().data + " ");
				}
			}

			else if (currentNode.rightNode == prevNode) {

				System.out.print(stack.pop().data + " ");

			}
			prevNode = currentNode;
		}

	}

	/**
	 * (BFS) This method prints the nodes level wise from left to right. It
	 * first calculate the height of the tree and then iterate over the levels
	 * to print the node for that level
	 * 
	 * @param treeNode
	 */
	public void printLevelOrderTreeTraversal(TreeNode treeNode) {

		// Getting height of the tree
		int treeHeight = getTreeHeight(treeNode);

		for (int level = 1; level <= treeHeight; level++) {
			printPartLevel(treeNode, level);

		}
	}

	/**
	 * This method prints all nodes for a particular level
	 * 
	 * @param treeNode
	 * @param level
	 */
	private void printPartLevel(TreeNode treeNode, int level) {

		if (treeNode == null) {
			return;
		}
		else {
			if (level == 1) {
				System.out.print(treeNode.data + " ");
			}
			else {
				// keep of decreasing the level
				printPartLevel(treeNode.leftNode, level - 1);
				printPartLevel(treeNode.rightNode, level - 1);
			}
		}
	}

	/**
	 * 
	 * @author maithiljanardan
	 * @param treeNode
	 * @return
	 * 
	 * 		This method return the height of the tree. The height of left and
	 *         right subtree is calculated recursively and then the max of the
	 *         two plus one(root node) is returned
	 */
	private int getTreeHeight(TreeNode treeNode) {

		// Returns 0
		if (treeNode == null) {
			return 0;
		}
		else {

			// get left and right subtree height
			int leftHeight = getTreeHeight(treeNode.leftNode);
			int rightHeight = getTreeHeight(treeNode.rightNode);

			if (leftHeight > rightHeight)
				return (leftHeight + 1);
			return (rightHeight + 1);
		}
	}

	/**
	 * Uses queue to print level order for a binary tree Takes root as parameter
	 * and enqueues it into the queue and then iterates while queue is not empty
	 * simultaneously enqueuing left and right child of the current node
	 * 
	 * @param root
	 * 
	 */
	public void printLevelOrderTreeTraversalUsingQueue(TreeNode treeNode) {

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(treeNode);
		while (!queue.isEmpty()) {

			TreeNode currentNode = queue.poll();
			System.out.print(currentNode.data + " ");
			if (currentNode.leftNode != null)
				queue.add(currentNode.leftNode);
			if (currentNode.rightNode != null)
				queue.add(currentNode.rightNode);
		}
	}

	/**
	 * 
	 * @param treeNode
	 * @return
	 * @author jd The diameter of a tree (sometimes called the width) is the
	 *         number of nodes on the longest path between two leaves in the
	 *         tree.
	 * 
	 * 
	 *         The diameter of a tree T is the largest of the following
	 *         quantities:
	 * 
	 *         1. the diameter of T�s left subtree
	 * 
	 *         2. the diameter of T�s right subtree
	 * 
	 *         3.the longest path between leaves that goes through the root of T
	 *         (this can be computed from the heights of the subtrees of T)
	 * 
	 */
	public int printDiameterOfBinaryTree(TreeNode treeNode) {

		if (treeNode == null) {
			return 0;
		}
		else {

			return Math.max(getTreeHeight(treeNode.leftNode) + getTreeHeight(treeNode.rightNode) + 1,
					Math.max(printDiameterOfBinaryTree(treeNode.leftNode), printDiameterOfBinaryTree(treeNode.rightNode)));
		}
	}

	/**
	 * @author maithiljanardan
	 * @param This
	 *            method takes root of the tree as an input and print the height
	 *            of the tree
	 * 
	 */
	public int printHeightTree(TreeNode treeNode) {

		if (treeNode == null)
			return 0;

		return (Math.max(getTreeHeight(treeNode.leftNode), getTreeHeight(treeNode.rightNode)) + 1);
	}

	/**
	 * @author maithiljanardan
	 * @param
	 * 
	 * 
	 */
	public TreeNode cloneBinaryTree(TreeNode treeNode) {

		if (treeNode == null) {
			return treeNode;
		}

		TreeNode clonedTreeNode = new TreeNode(treeNode.data);
		clonedTreeNode.leftNode = cloneBinaryTree(treeNode.leftNode);
		clonedTreeNode.rightNode = cloneBinaryTree(treeNode.rightNode);

		return clonedTreeNode;

	}

	/**
	 * @author maithiljanardan
	 * 
	 *         This method print max width of a tree both using recursive and
	 *         queue method
	 */

	/**
	 * 
	 * This method print node at k distance from root
	 */
	public void printKDistant(TreeNode treeNode, int k) {
		if (treeNode == null)
			return;
		if (k == 0) {
			System.out.print(treeNode.data + " ");
			return;
		}
		else {
			printKDistant(treeNode.leftNode, k - 1);
			printKDistant(treeNode.rightNode, k - 1);
		}
	}

	public TreeNode getLCABetweenTwoNodes(TreeNode root, int key1, int key2) {

		if (root == null)
			return root;

		// If either n1 or n2 matches with root's key, report the presence by
		// returning root (Note that if a key is
		// ancestor of other, then the ancestor key becomes LCA
		if (root.data == key1 || root.data == key2)
			return root;

		// Look for keys in left and right subtrees
		TreeNode leftLCA = getLCABetweenTwoNodes(root.leftNode, key1, key2);
		TreeNode rightLCA = getLCABetweenTwoNodes(root.rightNode, key1, key2);

		// If both of the above calls return Non-NULL, then one key
		// is present in once subtree and other is present in other,
		// So this node is the LCA
		if (leftLCA != null && rightLCA != null)
			return root;

		return (leftLCA == null) ? rightLCA : leftLCA;
	}

	/**
	 * 
	 * 
	 * This method returns the size of the binary tree
	 * 
	 * @param root
	 *            takes root node as input parameter
	 * @return the nodes present in the tree
	 */
	public int getSizeOfTree(TreeNode root) {

		if (root == null)
			return 0;
		return (getSizeOfTree(root.leftNode) + getSizeOfTree(root.rightNode) + 1);
	}

	/**
	 * Checks whether the the trees are identical
	 * 
	 * @param root
	 * @return
	 */
	public boolean isIdentical(TreeNode rootA, TreeNode rootB) {

		if (rootA == null && rootB == null)
			return false;
		else
			return ((rootA.data == rootB.data) && (isIdentical(rootA.leftNode, rootB.leftNode)) && (isIdentical(rootA.rightNode, rootB.rightNode)));
	}

	/**
	 * This function is same as deleteTree() in the previous program
	 * 
	 */
	private void deleteTreeUtil(TreeNode node) {
		if (node == null) {
			return;
		}

		/* first delete both subtrees */
		deleteTreeUtil(node.leftNode);
		deleteTreeUtil(node.rightNode);

		/* then delete the node */
		System.out.println("The deleted node is " + node.data);
		node = null;
	}

	/**
	 * Wrapper function that deletes the tree and sets root node as null
	 */
	public void deleteTree(TreeNode nodeRef) {
		deleteTreeUtil(nodeRef);
		nodeRef = null;
	}
}
