package algorithm;

import Data_Structure.ListNode;

import java.util.HashMap;

/**
 * @author l
 */
public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode preHead = new ListNode();
        preHead.next = head;
        int index = 1;
        ListNode leftNodePre = preHead;
        while(head != null){
            if (index == left){
                break;
            }else{
                index++;
                leftNodePre = head;
                head = head.next;
            }
        }
        ListNode root = head;
        ListNode pre = head;
        head = head.next;
        index++;
        while(head != null){
            if (index > right){
                break;
            }else{
                root.next = head.next;
                head.next = pre;
                pre = head;
                head = root.next;
                index++;
            }
        }
        leftNodePre.next = pre;
        return preHead.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ListNode roots = new ListNode(nums);
        ReverseBetween r = new ReverseBetween();
        ListNode res = r.reverseBetween(roots, 1, 9);
        System.out.println(res);
    }
}
