package algorithm;

import Data_Structure.TreeNode;

public class MergeTrees {
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null){
            return null;
        }
        TreeNode N = new TreeNode();
        int left = 0;
        int right = 0;
        if(t1 != null){
            left = t1.val;
        }
        if(t2 != null){
            right = t2.val;
        }
        N.val = left + right;
        
        N.left = this.mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        N.right = this.mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);

        return N;
    }
	
	public static void main(String[] args) {
		MergeTrees M = new MergeTrees();
		TreeNode a = new TreeNode(3);
		a.left = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode n = M.mergeTrees(a, b);
		System.out.println(n.val);
		System.out.println(n.left.val);
		
	}
}
