package algorithm;

import java.util.*;

import datastructure.TreeNode;

public class FindMode {
	public int[] findMode(TreeNode root) {
		Map<Integer, Integer> M = new HashMap<Integer, Integer>();
		
        Stack<TreeNode> S = new Stack<TreeNode>();
        while(!S.isEmpty() && root != null) {
        	S.push(root);
			root = root.left;
        }
        int[] nums = new int[2];
        return nums;
    }
	
	public static void main(String[] args) {
		FindMode F = new FindMode();
		
	}
	
}
