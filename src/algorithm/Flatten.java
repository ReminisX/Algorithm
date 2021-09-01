package algorithm;

import javax.swing.RootPaneContainer;

import Data_Structure.TreeNode;

public class Flatten {
	
	public void flatten(TreeNode root) {
		if(root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = null;
        while(root.right != null) root = root.right;
        root.right = tmp;
    }
}
