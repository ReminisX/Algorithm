package algorithm;

import java.util.Stack;

import Data_Structure.TreeNode;

public class IsSymmetric {
	public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }
    
    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
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
		IsSymmetric I = new IsSymmetric();
		System.out.println(I.isSymmetric(t3));
	}
}
