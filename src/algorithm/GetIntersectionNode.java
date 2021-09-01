package algorithm;

import java.util.Stack;

import Data_Structure.ListNode;

public class GetIntersectionNode {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode now = null;
		if(headA == null || headB == null) {
			return now;
		}
        Stack<ListNode> a = new Stack<ListNode>();
        Stack<ListNode> b = new Stack<ListNode>();
        while(headA != null) {
        	a.push(headA);
        	headA = headA.next;
        }
        while(headB != null) {
        	b.push(headB);
        	headB = headB.next;
        }
        
        if(a.isEmpty() || b.isEmpty()){
            return now;
        }
        while(a.peek() == b.peek()) {
        	now = a.peek();
        	a.pop();
        	b.pop();
        	if(a.isEmpty()) {
        		break;
        	}
        }
        return now;
    }
	
	public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
		if(headA ==null || headB == null) {
			return null;
		}
		ListNode a = headA;
		ListNode b = headB;
		while(a != b) {
			a = a == null ? headB : a.next;
			b = b == null ? headA : b.next;
		}
		return a;
	}
}
