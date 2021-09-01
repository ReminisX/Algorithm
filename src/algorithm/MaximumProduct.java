package algorithm;

import java.util.Arrays;

/**
 * @author l
 */
public class MaximumProduct {

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0]*nums[1]*nums[nums.length-1], nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3]);
    }

}
