package algorithm;

import java.util.Stack;

import Data_Structure.TreeNode;

public class LowestCommonAncestor {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == root || q == root) {
        	return root;
        }
        TreeNode left = this.lowestCommonAncestor(root.left, p, q);
        TreeNode right = this.lowestCommonAncestor(root.right, p, q);
        if(left == null && right == null) {
        	return null;
        }
        if(left != null && right != null) {
        	return root;
        }
        return left == null ? right : left;
    }
}
