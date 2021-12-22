package algorithm;

import datastructure.Node;

import java.util.Stack;

public class TreeToDoublyList {

    private Node pre;

    private Node head;

    public void dfs(Node node){
        if (node == null){
            return;
        }
        dfs(node.left);
        if(pre == null){
            head = node;
        }else{
            pre.right = node;
        }
        node.left = pre;
        pre = node;
        dfs(node.right);
    }

    public Node treeToDoublyList(Node root) {
        if(root == null){
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    public Node treeToDoublyList2(Node root){
        if (root == null){
            return null;
        }
        Stack<Node> s = new Stack<>();
        while(root != null || !s.isEmpty()){
            while(root != null){
                s.push(root);
                root = root.left;
            }
            root = s.pop();

            if (pre == null){
                head = root;
            }else{
                pre.right = root;
            }
            root.left = pre;
            pre = root;

            root = root.right;

        }
        pre.right = head;
        head.left = pre;
        return head;
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        Node a = new Node(2);
        root.left = a;
        Node aa = new Node(1);
        Node ab = new Node(3);
        a.left = aa;
        a.right = ab;
        Node b = new Node(5);
        root.right = b;

        TreeToDoublyList treeToDoublyList = new TreeToDoublyList();
        Node res = treeToDoublyList.treeToDoublyList2(root);
        while(res != null){
            System.out.print(res.right.val + "<->");
            res = res.right;
        }
    }

}
