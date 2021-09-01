package algorithm;

public class MaxSubArray {
	public int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int res = nums[0];
        int max = 0;
        for (int num : nums) {
            max = Math.max(max + num, num);
            res = Math.max(res, max);
        }
        return res;
    }
}
