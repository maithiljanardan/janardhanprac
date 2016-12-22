package org.janardhan.tree;

/**
 * 
 * @author jd. This Class containing left, right node and int data.
 */

public class TreeNode {

	int data;
	TreeNode leftNode, rightNode;

	public TreeNode(int data) {
		this.data = data;
		this.leftNode = this.rightNode = null;
	}

	@Override
	public String toString() {
		return "TreeNode = " + data;
	}
}
