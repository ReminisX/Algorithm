package algorithm;

import Data_Structure.ListNode;

public class SortList {
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = midNode(head);
        ListNode second = mid.next;
        mid.next = null;
        return merge(sortList(head), sortList(second));
    }
	
	public ListNode midNode(ListNode head) {
		ListNode mid = head;
		ListNode midfast = head;
		while(midfast.next != null && midfast.next.next != null) {
			midfast = midfast.next.next;
			mid = mid.next;
		}
		return mid;
	}
	
	public ListNode merge(ListNode left, ListNode right) {
		ListNode temp = new ListNode(0);
		ListNode pre = temp;
		while(left != null && right != null) {
			if(left.val < right.val) {
				pre.next = left;
				left = left.next;
				pre = pre.next;
			}else {
				pre.next = right;
				right = right.next;
				pre = pre.next;
			}
		}
		pre.next = left == null ? right : left;
		return temp.next;
	}
	
	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(6);
		a.next = b;
		ListNode c = new ListNode(8);
		b.next = c;
		ListNode d = new ListNode(3);
		c.next = d;
		ListNode e = new ListNode(7);
		d.next = e;
		ListNode f = new ListNode(2);
		e.next = f;
		ListNode g = new ListNode(0);
		f.next = g;
		ListNode h = new ListNode(9);
		g.next = h;
		
		SortList S = new SortList();
		S.sortList(a);
		ListNode head = a;
		while(head.next != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
}
