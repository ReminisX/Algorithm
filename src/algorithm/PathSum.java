package algorithm;

import com.sun.corba.se.spi.ior.IdentifiableFactory;
import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

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

	/**
	 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
	 * @param root 根节点
	 * @param target 目标值
	 * @return 所有满足要求的路径
	 */
	private List<List<Integer>> res = new ArrayList<>();

	private int target;

	public void dfs(TreeNode node, List<Integer> list, int num){
		if (num + node.val == target && node.left == null && node.right == null){
			list.add(node.val);
			res.add(list);
			return;
		}

		if (num + node.val != target){
			if (node.left != null){
				List<Integer> l = new ArrayList<>(list);
				l.add(node.val);
				dfs(node.left, l, num + node.val);
			}
			if (node.right != null){
				List<Integer> r = new ArrayList<>(list);
				r.add(node.val);
				dfs(node.right, r, num + node.val);
			}
		}
	}

	public List<List<Integer>> pathSum2(TreeNode root, int target) {
		this.target = target;
		dfs(root, new ArrayList<>(), 0);
		return res;
	}

	public static void main(String[] args) {
		PathSum pathSum = new PathSum();
		TreeNode root = new TreeNode(0);
		TreeNode a = new TreeNode(1);
		root.left = a;
		TreeNode b = new TreeNode(1);
		root.right = b;
//		TreeNode aa = new TreeNode(11);
//		a.left = aa;
//		TreeNode ba = new TreeNode(13);
//		b.left = ba;
//		TreeNode bb = new TreeNode(4);
//		b.right = bb;
//		TreeNode aaa = new TreeNode(7);
//		aa.left = aaa;
//		TreeNode aab = new TreeNode(2);
//		aa.right = aab;
//		TreeNode bba = new TreeNode(5);
//		bb.left = bba;
//		TreeNode bbb = new TreeNode(1);
//		bb.right = bbb;
		List res = pathSum.pathSum2(root, 1);
		System.out.println(res);
	}
}
