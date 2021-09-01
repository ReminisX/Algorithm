package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class GetLeastNumbers_Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if(k > input.length){
            return res;
        }
        Queue<Integer> q = new PriorityQueue<>(k);
        for(int i = 0; i < input.length; i++){
            q.add(input[i]);
        }
        for(int i = 0; i < k; i++){
            res.add(q.poll());
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2, 5, 6, 7, 0, 9, 8};
        int k = 5;
        List<Integer> res = new GetLeastNumbers_Solution().GetLeastNumbers_Solution(nums, k);
        System.out.println(res);
    }
}
