package algorithm;


import Data_Structure.TreeNode;

public class BuildTree {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		// 边界情况判断
		if(preorder.length == 0) {
			return null;
		}
		// 初始化根节点
        TreeNode N = new TreeNode(preorder[0]);
        // 计算分割中序遍历数组的坐标
        int k = 0;
        for (int i = 0; i < inorder.length; i++) {
			if(inorder[i] == N.val) {
				k = i;
			}
		}
        // 分割中序数组
        int[] inorder_left = new int[k];
        int[] inorder_right = new int[inorder.length - k - 1];
        for (int i = 0; i < inorder_left.length; i++) {
			inorder_left[i] = inorder[i];
		}
        for (int i = 0; i < inorder_right.length; i++) {
			inorder_right[i] = inorder[k+i+1];
		}
        // 分割前序数组
        int[] preorder_left = new int[inorder_left.length];
        int[] preorder_right = new int[inorder_right.length];
        for (int i = 0; i < preorder_left.length; i++) {
			preorder_left[i] = preorder[i+1];
		}
        for (int i = 0; i < preorder_right.length; i++) {
			preorder_right[i] = preorder[preorder_left.length + i + 1];
		}
        //递归求解
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
	
	public static void main(String[] args) {
		int[] preorder = {3, 9, 20, 15, 7};
		int[] inorder = {9, 3, 15, 20, 7};
		BuildTree B = new BuildTree();
		TreeNode N = B.buildTree(preorder, inorder);
		B.printTree(N);
	}
}
