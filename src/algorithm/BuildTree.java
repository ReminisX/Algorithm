package algorithm;


import datastructure.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class BuildTree {
	public TreeNode buildTreeOld(int[] preorder, int[] inorder) {
		if(preorder.length == 0) {
			return null;
		}
        TreeNode N = new TreeNode(preorder[0]);
        int k = 0;
        for (int i = 0; i < inorder.length; i++) {
			if(inorder[i] == N.val) {
				k = i;
			}
		}
        int[] inorder_left = new int[k];
        int[] inorder_right = new int[inorder.length - k - 1];
        for (int i = 0; i < inorder_left.length; i++) {
			inorder_left[i] = inorder[i];
		}
        for (int i = 0; i < inorder_right.length; i++) {
			inorder_right[i] = inorder[k+i+1];
		}
        int[] preorder_left = new int[inorder_left.length];
        int[] preorder_right = new int[inorder_right.length];
        for (int i = 0; i < preorder_left.length; i++) {
			preorder_left[i] = preorder[i+1];
		}
        for (int i = 0; i < preorder_right.length; i++) {
			preorder_right[i] = preorder[preorder_left.length + i + 1];
		}
        N.left = this.buildTree(preorder_left, inorder_left);
        N.right = this.buildTree(preorder_right, inorder_right);
        return N;
    }
	
	public void printTree(TreeNode N) {
		if(N.left != null) {
			this.printTree(N.left);
		}
		System.out.println(N.val);
		if(N.right != null) {
			this.printTree(N.right);
		}
	}

	/**
	 数组拷贝方法
	 */
	public int[] cutArray(int[] nums, int left, int right){
		int[] res = new int[right-left];
		for(int i = left; i < right; i++){
			res[i-left] = nums[i];
		}
		return res;
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0){
			return null;
		}
		if(preorder.length == 1 && inorder.length == 1){
			return new TreeNode(preorder[0]);
		}
		// 中值确定
		int val = preorder[0];
		TreeNode node = new TreeNode(val);
		// 切点
		int inCut = -1;
		for(int i = 0; i < inorder.length; i++){
			if(inorder[i] == val){
				inCut = i;
				break;
			}
		}
		// 数组切片
		int[] inorderLeft = cutArray(inorder, 0, inCut);
		int[] inorderRight = cutArray(inorder, inCut+1, inorder.length);
		// 寻找先序遍历切点
		Set<Integer> preorderLeftSet = new HashSet<>();
		for(int i = 0; i < inCut; i++){
			preorderLeftSet.add(inorder[i]);
		}
		int preCut = preorder.length;
		for(int i = 1; i < preorder.length; i++){
			if(!preorderLeftSet.isEmpty()){
				preorderLeftSet.remove(preorder[i]);
			}else{
				preCut = i;
				break;
			}
		}
		int[] preorderLeft = cutArray(preorder, 1, preCut);
		int[] preorderRight = cutArray(preorder, preCut, preorder.length);
		// 点连接
		node.left = buildTree(preorderLeft, inorderLeft);
		node.right = buildTree(preorderRight, inorderRight);
		return node;
	}
	
	public static void main(String[] args) {
		int[] preorder = {1, 2};
		int[] inorder = {2, 1};
		BuildTree B = new BuildTree();
		TreeNode N = B.buildTree(preorder, inorder);
		B.printTree(N);
	}
}
