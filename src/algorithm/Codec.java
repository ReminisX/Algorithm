package algorithm;

import Data_Structure.TreeNode;

public class Codec {
	private int index = -1;
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
        	return "#,";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val + ",");
        sb.append(this.serialize(root.left));
        sb.append(this.serialize(root.right));
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        return helper(data.split(","));
    }
    
    private TreeNode helper(String[] strs) {
        index++;
        if ("#".equals(strs[index])) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(strs[index]));
        node.left = helper(strs);
        node.right = helper(strs);
        return node;
    }
    
    public static void main(String[] args) {
    	TreeNode a = new TreeNode(1);
    	TreeNode b = new TreeNode(2);
    	a.left = b;
    	TreeNode c = new TreeNode(3);
    	a.right = c;
    	TreeNode d = new TreeNode(4);
    	c.right = d;
    	Codec C = new Codec();
    	String s= C.serialize(a);
    	System.out.println(s);
    	
    }
}
