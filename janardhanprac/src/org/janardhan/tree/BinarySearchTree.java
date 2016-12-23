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

	private void maxValue(TreeNode treeNode) {
		int maxv = treeNode.data;
		while (treeNode.rightNode != null) {
			treeNode = treeNode.rightNode;
			maxv = treeNode.data;
		}
		System.out.println("Predecessor Node is " + maxv);
	}

	public void printInorderPreAndSuc(TreeNode treeNode, int key) {
		printInorderPre(treeNode, key);
		printInorderSuc(treeNode, key);

	}

	private void printInorderPre(TreeNode treeNode, int key) {

		if (treeNode == null)
			return;

		if (treeNode.data == key) {
			maxValue(treeNode.leftNode);
		} else if (key < treeNode.data)
			printInorderPre(treeNode.leftNode, key);

		else
			printInorderPre(treeNode.rightNode, key);

	}

	private void printInorderSuc(TreeNode treeNode, int key) {

		if (treeNode == null)
			return;

		if (treeNode.data == key) {
			minValue2(treeNode.rightNode);
		} else if (key < treeNode.data)
			printInorderSuc(treeNode.leftNode, key);

		else
			printInorderSuc(treeNode.rightNode, key);

	}

	/***
	 * @return
	 * @see String
	 * @param treeNode
	 */
	private void minValue2(TreeNode treeNode) {
		int minv = treeNode.data;
		while (treeNode.leftNode != null) {
			treeNode = treeNode.leftNode;
			minv = treeNode.data;
		}
		System.out.println("Successor Node is " + minv);
	}

	public boolean isTreeBST(TreeNode root, int min, int max) {

		if (root == null)
			return true;
		if (root.data < min || root.data > max)
			return false;

		return (isTreeBST(root.leftNode, min, root.data) && isTreeBST(root.rightNode, root.data, max));
	}

	/**
	 * @author jd
	 * @param root
	 * @param key1
	 * @param key2
	 * @return
	 * 
	 * 		This method gets the Lowest Common Ancestor. The lowest common
	 *         ancestor between two nodes n1 and n2 is defined as the lowest
	 *         node in T that has both n1 and n2 as descendants (where we allow
	 *         a node to be a descendant of itself).
	 * 
	 * 
	 *         Computation of lowest common ancestors may be useful, for
	 *         instance, as part of a procedure for determining the distance
	 *         between pairs of nodes in a tree: the distance from n1 to n2 can
	 *         be computed as the distance from the root to n1, plus the
	 *         distance from the root to n2, minus twice the distance from the
	 *         root to their lowest common ancestor.
	 * 
	 *         The idea is to recursively traverse in the tree till we get
	 *         common parent
	 * 
	 * 
	 */
	public TreeNode getLowestCommonAncestor(TreeNode root, int key1, int key2) {

		if (root == null)
			return root;

		if (root.data > key1 && root.data > key2)
			return getLowestCommonAncestor(root.leftNode, key1, key2);

		if (root.data < key1 && root.data < key2)
			return getLowestCommonAncestor(root.rightNode, key1, key2);

		return root;
	}
}
