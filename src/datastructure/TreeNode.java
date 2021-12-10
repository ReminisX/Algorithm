package datastructure;

import java.util.*;

/**
 * @author l
 */
public class TreeNode {
		 public int val;
		 public TreeNode left;
		 public TreeNode right;
		 public TreeNode() {}
		 public TreeNode(int x) {
			 val = x;
		 }
		 public TreeNode(int val, TreeNode left, TreeNode right) {
			 this.val = val;
			 this.left = left;
			 this.right = right;
		 }

		 public void initTestTree(){
		 	this.val = 0;
		 	TreeNode a = new TreeNode(1);
		 	TreeNode b = new TreeNode(2);
		 	TreeNode c = new TreeNode(3, a, b);
		 	TreeNode d = new TreeNode(4);
		 	this.left = c;
		 	this.right = d;
		 }

	 	public String preOrder(){
			 TreeNode t = new TreeNode(this.val, this.left, this.right);
			 StringBuilder sb = new StringBuilder();
			 Stack<TreeNode> s = new Stack();
			 s.push(t);
			 while(!s.isEmpty()){
			 	t = s.pop();
			 	sb.append(t.val + "->");
			 	if (t.right != null){
			 		s.push(t.right);
				}
			 	if (t.left != null){
			 		s.push(t.left);
				}
			 }
			 return sb.substring(0, sb.length()-2);
		 }

		public String inOrder(){
		 	StringBuilder sb = new StringBuilder();
			Stack<TreeNode> s = new Stack<>();
			TreeNode t = new TreeNode(this.val, this.left, this.right);
			while (t != null || !s.isEmpty()) {
				while (t != null) {
					s.push(t);
					t = t.left;
				}

				if (!s.isEmpty()) {
					t = s.pop();
					sb.append(t.val);
					sb.append("->");
					t = t.right;
				}
			}
			return sb.substring(0, sb.length()-2);
		}

		public String posOrder(){
			StringBuilder sb = new StringBuilder();
			Stack<TreeNode> s1 = new Stack<>();
			Stack<TreeNode> s2 = new Stack<>();
			TreeNode t = new TreeNode(this.val, this.left, this.right);
			s1.push(t);
			while(!s1.isEmpty()){
				t = s1.pop();
				s2.push(t);
				if(t.left != null){
					s1.push(t.left);
				}
				if(t.right != null){
					s1.push(t.right);
				}
			}
			while(!s2.isEmpty()){
				sb.append(s2.pop().val + "->");
			}
			return sb.substring(0, sb.length()-2);
		}

		public String levelOrder(){
			StringBuilder sb = new StringBuilder();
			TreeNode t = new TreeNode(this.val, this.left, this.right);
			Queue<TreeNode> q = new LinkedList<>();
			q.add(t);
			while(!q.isEmpty()){
				t = q.poll();
				sb.append(t.val + "->");
				if (t.left != null){
					q.add(t.left);
				}
				if (t.right != null){
					q.add(t.right);
				}
			}
			return sb.substring(0, sb.length()-2);
		}

		@Override
		public String toString(){
		 	List<List<Integer>> L = new ArrayList<>();
			int level = 0;
			int index = 0;
			Queue<TreeNode> q = new LinkedList<>();
			TreeNode t = new TreeNode(this.val, this.left, this.right);
			q.add(t);

			while(!q.isEmpty()){
				t = q.poll();
				index++;
				if (index > Math.pow(2, level)){
					level++;
					index = 1;
				}
				if (L.size() <= level){
					L.add(new ArrayList<>((int)Math.pow(2, level)));
					L.get(level).add(t.val);
				}else{
					L.get(level).add(t.val);
				}
				if (t.left != null){
					q.add(t.left);
				}else if(t.val != Integer.MIN_VALUE){
					q.add(new TreeNode(Integer.MIN_VALUE));
				}
				if (t.right != null){
					q.add(t.right);
				}else if(t.val != Integer.MIN_VALUE){
					q.add(new TreeNode(Integer.MIN_VALUE));
				}
			}

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < L.size()-1; i++) {
				List<Integer> l = L.get(i);
				for (int j = 0; j < l.size(); j++) {
					if (l.get(j) == Integer.MIN_VALUE){
						sb.append("/ ");
					}else{
						sb.append(l.get(j) + " ");
					}
				}
				sb.delete(sb.length()-1, sb.length());
				sb.append("\n");
			}
			sb.delete(sb.length()-1, sb.length());

		 	return sb.toString();
		}
}
