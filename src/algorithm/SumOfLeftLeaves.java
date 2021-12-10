package algorithm;

import datastructure.TreeNode;

public class SumOfLeftLeaves {
	public int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return 0;
        }
        int res = this.sumOfLeftLeaves(root.left) + this.sumOfLeftLeaves(root.right);

        if(root.left != null && root.left.left == null && root.left.right == null){
            res += root.left.val;
        }

        return res;

    }
}
