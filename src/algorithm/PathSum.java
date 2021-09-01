package algorithm;

import Data_Structure.TreeNode;

public class PathSum {
	public int pathSum(TreeNode root, int sum) {
        
		if(root == null) {
			return 0;
		}
		
		return this.countPathSum(root, sum) + this.pathSum(root.left, sum) + this.pathSum(root.right, sum);
		
    }
	
	public int countPathSum(TreeNode root, int sum) {
		
		if(root == null) {
			return 0;
		}
		
		return (root.val == sum ? 1 : 0) + this.countPathSum(root.left, sum - root.val) + this.countPathSum(root.right, sum - root.val);
		
	}
}
