package algorithm;

import Data_Structure.ListNode;

/**
 * @author l
 */
public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if ( head == null || head.next == null){
            return head;
        }
        ListNode now = head;
        ListNode H = head;
        for (int i = 0; i < k; i++) {
            if (now.next == null){
                now = head;
            }else{
                now = now.next;
            }
        }
        if(now == head){
            return head;
        }
        while (now.next != null){
            now = now.next;
            head = head.next;
        }
        ListNode res = head.next;
        head.next = null;
        now.next = H;
        return res;
    }
}
