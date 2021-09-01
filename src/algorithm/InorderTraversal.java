package algorithm;

import java.util.ArrayList;
import java.util.List;

import Data_Structure.TreeNode;

public class InorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> L = new ArrayList<Integer>();
		if( root == null) {
			return L;
		}
		if(root.left != null) {
			L = this.inorderTraversal(root.left);
		}
		L.add(root.val);
		if(root.right != null) {
			L.addAll(this.inorderTraversal(root.right));
		}
		return L;
    }
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		t1.left = t2;
		TreeNode t3 = new TreeNode(3);
		t1.right = t3;
		InorderTraversal I = new InorderTraversal();
		List<Integer> L = I.inorderTraversal(t1);
		System.out.println(L);
	}
}
