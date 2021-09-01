package algorithm;

public class MaxSlidingWindow {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if(nums.length == 0 || k == 0) {
			return null;
		}
		if(k == 1) {
			return nums;
		}
		int left = 0;
		int right = k-1;
		int max = this.maxNums(nums, 0, k-1);
		int[] res = new int[nums.length - k + 1];
		res[0] = max;
		for (int i = k; i < nums.length; i++) {
			
			right++;
			if(nums[left] >= max) {
				max = this.maxNums(nums, left+1, right);
				res[i-k+1] = max;
			}
			if(nums[right] > max) {
				max = nums[right];
				res[i-k+1] = max;
			}
			res[i-k+1] = max;
		}
		left++;
		return res;
    }
	
	public int maxNums(int[] nums, int i, int j) {
		int res = nums[i];
		for (int k = i+1; k <= j; k++) {
			if(nums[k] > res) {
				res = nums[k];
			}
		}
		return res;
	}
}
