package algorithm;

import datastructure.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class IsValidBST {
	Integer k;
	public boolean isValidBST(TreeNode root) {
		boolean b1 = true, b2 = true;
		boolean b;
		if(root == null) {
			return true;
		}
		
		b1 = this.isValidBST(root.left);
		if(this.k == null) {
			b = true;
			k = root.val;
		}else if( this.k < root.val) {
			b = true;
			k = root.val;
		}else {
			b = false;
		}
		
		b2 = this.isValidBST(root.right);
		
		return b&&b1&&b2;
    }
	
	public static void main(String[] args) {
		TreeNode t5 = new TreeNode(5);
		TreeNode t4 = new TreeNode(4);
		TreeNode t3 = new TreeNode(3);
		TreeNode t2 = new TreeNode(2);
		TreeNode t1 = new TreeNode(1);
		t3.left = t2;
		t3.right = t4;
		t2.left = t1;
		t4.right = t5;
		IsValidBST I = new IsValidBST();
		System.out.println(I.isValidBST(t3));
	}
	
}
