package algorithm;

import Data_Structure.TreeNode;

import java.util.Stack;

public class MinDiffInBST {
    public int minDiffInBST(TreeNode root) {
        int res = Integer.MAX_VALUE;
        TreeNode pre = null;
        Stack<TreeNode> s = new Stack<>();
        while(root != null || !s.isEmpty()) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }

            if (!s.isEmpty()) {
                root = s.pop();
                if (pre == null) {
                    pre = root;
                } else {
                    res = Math.min(root.val - pre.val, res);
                    pre = root;
                }
                root = root.right;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.initTestTree();
        String str = root.inOrder();
        System.out.println(str);
        int res = new MinDiffInBST().minDiffInBST(root);
        System.out.println(res);
    }
}
