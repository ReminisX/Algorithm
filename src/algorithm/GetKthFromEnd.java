package algorithm;

import datastructure.ListNode;

public class GetKthFromEnd {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode H = new ListNode(0);
        H.next = head;
        ListNode node = H;
        while(k > 0){
            head = head.next;
            --k;
        }
        while(head != null){
            node = node.next;
            head = head.next;
        }
        return node;
    }

}
