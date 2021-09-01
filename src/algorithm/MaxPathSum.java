package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import Data_Structure.TreeNode;

public class MaxPathSum {
    private int res = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        helper(root);
        return res;
    }
    
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        res = Math.max(res, left + right + root.val);
        return root.val + Math.max(left, right);
    }

	
	public int pathPoint(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		root.val = root.val + Math.max(Math.max(this.pathPoint(root.left), this.pathPoint(root.right)), 0);
		return root.val;
	}
	
	public void showTree(TreeNode N) {
		if(N == null) {
			return;
		}
		
		if(N.left != null) {
			this.showTree(N.left);
		}
		System.out.println(N.val);
		if(N.right != null) {
			this.showTree(N.right);
		}
		
	}
	
	public static void main(String[] args) {
		TreeNode a = new TreeNode(9);
		TreeNode b = new TreeNode(-10);
		TreeNode c = new TreeNode(20);
		TreeNode d = new TreeNode(15);
		TreeNode e = new TreeNode(7);
		b.left = a;
		b.right = c;
		c.left = d;
		c.right = e;
		
		MaxPathSum P = new MaxPathSum();
		int k = P.maxPathSum(b);
		System.out.println(k);
		
	}
	
}
