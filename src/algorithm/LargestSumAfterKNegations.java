package algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LargestSumAfterKNegations {

    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
        int pointCut = nums[0] < 0 ? nums.length-1 : 0;
        // 数组累加值
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i+1 < nums.length && nums[i]*nums[i+1] <= 0){
                pointCut = Math.abs(nums[i]) > Math.abs(nums[i+1]) ? i+1 : i;
            }
        }
        // 循环k次修改sum
        int index = 0;
        for (int i = 0; i < k; i++) {
            nums[index] = - nums[index];
            sum += (2 * nums[index]);
            if (index < pointCut){
                index++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        LargestSumAfterKNegations largestSumAfterKNegations = new LargestSumAfterKNegations();
        //int[] num = {3,-17,-11,-23,21,30,27,-16,-21,-6,-22,27,-4,23,-2,22,25,14,14,1,-13,4,23,7,26,17,22,-6,24,4,-2,-23,7,14,-3,-21,-27,-23,17,13,-20,3,-9,-14,27,-11,-1,-20,-27,6,20,9,26,29,-1,20,16,-28,-16,21,-13,-5,17,-28,-3,-5,-8,17,-17,-18,-22,28,-17,11,-6,9,16,21,-19,27,-19,30,16,5,-23,-10,28,-7,16,10,-14,-18,14,-15,16,-30,-28,25,25,4, 100};
        //int res = largestSumAfterKNegations.largestSumAfterKNegations(num, 100);
        int[] nums = {-4, -2, -3};
        int r = largestSumAfterKNegations.largestSumAfterKNegations(nums, 4);
        System.out.println(r);
    }

}
