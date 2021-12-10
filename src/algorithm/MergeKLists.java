package algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import datastructure.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class MergeKLists {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;

        Queue<ListNode> minHeap = new PriorityQueue<ListNode>(Comparator.comparingInt(node -> node.val));
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }

        while (!minHeap.isEmpty()) {
            pre.next = minHeap.poll();
            pre = pre.next;
            if (pre.next != null) {
                minHeap.offer(pre.next);
            }
        }

        return dummy.next;
    }
	
	public static void main(String[] args) {
		MergeKLists M = new MergeKLists();
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(4);
		ListNode a3 = new ListNode(5);
		a1.next = a2;
		a2.next = a3;
		ListNode b1 = new ListNode(1);
		ListNode b2 = new ListNode(3);
		ListNode b3 = new ListNode(4);
		b1.next = b2;
		b2.next = b3;
		ListNode c1 = new ListNode(2);
		ListNode c2 = new ListNode(6);
		c1.next = c2;
		
		ListNode[] lists = {a1, b1, c1};
		
		ListNode N = M.mergeKLists(lists);
		
		while(N != null) {
			System.out.println(N.val);
			N = N.next;
		}
		
	}
}
