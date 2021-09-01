package algorithm;

import Data_Structure.ListNode;

/**
 * @author l
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode prehead = new ListNode();
        prehead.next = head;
        ListNode pre = prehead;
        pre.next = head;
        boolean deleteHead = false;
        while(head.next != null){
            if(head.next.val == head.val){
                head.next = head.next.next;
                deleteHead = true;
            }else{
                if(deleteHead){
                    pre.next = head.next;
                    head = pre.next;
                    deleteHead = false;
                }else{
                    pre = head;
                    head = head.next;
                }
            }
        }
        if(deleteHead){
            pre.next = head.next;
            head = pre.next;
            deleteHead = false;
        }else{
            pre = head;
            head = head.next;
        }
        return prehead.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1};
        ListNode res = new DeleteDuplicates().deleteDuplicates(new ListNode(nums));
        System.out.println(res);
    }
}
