package algorithm;

import Data_Structure.ListNode;

public class ReverseList {
	public ListNode reverseList(ListNode head) {
		ListNode prev = null;
        while (head!= null) {
            ListNode nextTemp = head.next;
            head.next = prev;
            prev = head;
            head = nextTemp;
        }
        return prev;
    }
	
	public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
