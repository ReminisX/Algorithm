package algorithm;

import datastructure.ListNode;

public class DeleteNode {

    public ListNode deleteNode(ListNode head, int val) {
        ListNode H = new ListNode(0);
        H.next = head;
        ListNode node = H;

        while(node.next != null){
            int x = node.next.val;
            if(x == val){
                node.next = node.next.next == null ? null : node.next.next;
                break;
            }
            node = node.next;
        }

        return H.next;
    }

}
