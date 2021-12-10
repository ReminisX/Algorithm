package algorithm;

import datastructure.ListNode;

import java.util.HashSet;

/**
 * @author ZhangXiaodong
 */
public class RemoveStone {
    public int find(int[] parents, int index){
        if(parents[index] != index){
            parents[index] = find(parents, parents[index]);
        }
        return parents[index];
    }

    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index2)] = find(parent, index1);
    }

    public int removeStones(int[][] stones) {
        // 并查集初始化
        int[] parents = new int[stones.length];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        // 遍历stones
        for (int i = 0; i < stones.length; i++) {
            for (int j = i+1; j < stones.length; j++) {
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                    union(parents, i, j);
                }
            }
        }
        //刷新并查集
        for (int i = 0; i < parents.length; i++) {
            parents[i] = find(parents, i);
        }
        // 根据并查集确定结果
        HashSet S = new HashSet<Integer>();
        for (int i = 0; i < parents.length; i++) {
            S.add(parents[i]);
        }
        return parents.length-S.size();
    }

    public static void main(String[] args) {
        RemoveStone R = new RemoveStone();
        int[][] stones = new int[][]{ {0, 1}, {1, 0}, {1, 1}};
        int res = R.removeStones(stones);
        System.out.println(res);
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    public static class RemoveNthFromEnd {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if(head.next == null) {
                return null;
            }
            ListNode preA = head;
            ListNode A = head;
            ListNode B = head;
            for(int i = 0; i < n-2; i++) {
                B = B.next;
            }
            while(B.next != null) {
                preA = A;
                A = A.next;
                B = B.next;
            }
            preA.next = A.next;
            return head;
        }

        public static void main(String[] args) {
            RemoveNthFromEnd R = new RemoveNthFromEnd();
            ListNode A = new ListNode(1);
            ListNode B = new ListNode(2);
            A.next = B;
            ListNode h = R.removeNthFromEnd(A, 1);
            while(A != null) {
                System.out.println(A.val);
                A = A.next;
            }
        }
    }
}
