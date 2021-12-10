package algorithm;

import datastructure.TreeNode;

public class InvertTree {
	public TreeNode invertTree(TreeNode root) {
		if(root == null) {
			return null;
		}
		TreeNode N = this.invertTree(root.left);
		root.left = this.invertTree(root.right);
		root.right = N;
		return root;
    }
}
