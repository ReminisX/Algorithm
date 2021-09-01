package algorithm;

public class CanPartition {
	public boolean canPartition(int[] nums) {
		if(nums == null || nums.length == 0) {
			return true;
		}
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		int sum_half = sum/2;
        double d = sum;
        double sum_half_real = d/2;
		if(sum_half - sum_half_real != 0) {
			return false;
		}
		int[] dp = new int[sum_half];
		if(nums[0]-1 < dp.length) {
			dp[nums[0]-1] = 1;
		}
		
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < dp.length; j++) {
				if(dp[j] != 0 && j+nums[i] < dp.length) {
					dp[j+nums[i]]++;
				}
			}
			if(nums[i]-1 < dp.length) {
				dp[nums[i]-1]++;
			}
		}
		if(nums[nums.length-1] == 0) {
			return false;
		}else {
			return true;
		}
    }
	
	public static void main(String[] args) {
		CanPartition C = new CanPartition();
		int[] nums = { 1, 5, 11, 5 };
		boolean b = C.canPartition(nums);
		System.out.println(b);
	}
	
}
