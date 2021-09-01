package algorithm;

import Data_Structure.ListNode;

public class HasCycle {
	public boolean hasCycle(ListNode head) {
		if (head == null) {
            return false;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        return fast != null && fast.next != null;
    }
}
