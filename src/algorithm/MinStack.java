package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinStack {
    private class Node {
        private int val;
        Node left;
        Node right;
        
        private Node(int val) {
        	this.val = val;
        }
    }
	private Node head = new Node(0);
	private Node min = new Node(0);
    public MinStack() {
    	
    }
    
    public void push(int x) {
    	// ��ջ�����
    	Node N = new Node(x);
    	head.right = N;
    	N.left = head;
    	head = head.right;
    	// ��Сջ�����
    	Node N_min = new Node(x);
    	// ��ʼ������
    	if(min.right == null) {
    		min.right = N_min;
    		N_min.left = min;
    		return;
    	}
    	Node point = min;
    	// Ѱ�Ҳ����
    	while(N_min.val > point.right.val) {
    		point = point.right;
    		if(point.right == null) {
        		break;
        	}
    	}
    	if(point.right == null) {
    		point.right = N_min;
    		N_min.left = point;
    	}else {
    		N_min.left = point;
    		N_min.right = point.right;
    		point.right = N_min;
    		N_min.right.left = N_min;
    	}
    	
    }
    
    public void pop() {
    	Node N = head;
    	// ��ջ������
    	head = head.left;
    	head.right = null;
    	// ��Сջ������
    	Node point = min.right;
    	while(N.val != point.val) {
    		point = point.right;
    	}
    	if(point.right == null) {
    		point.left.right = null;
    		point.left = null;
    	}else {
    		point.left.right = point.right;
    		point.right.left = point.left;
    		point.left = null;
    		point.right = null;
    	}
    }
    
    public int top() {
    	return head.val;
    }
    
    public int getMin() {
    	return this.min.right.val;
    }
    
    public static void main(String[] args) {
    	MinStack m = new MinStack();
    	m.push(3);
    	m.push(2);
    	m.push(1);
    	m.push(6);
    	System.out.println(m.top());
    	System.out.println(m.getMin());
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

