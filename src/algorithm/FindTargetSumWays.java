package algorithm;

public class FindTargetSumWays {
	public int findTargetSumWays(int[] nums, int S) {
		int res = 0;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		if(sum == S) {
			res++;
		}
		
		int[][] dp = new int[nums.length][nums.length];
		for (int i = 0; i < dp.length; i++) {
			for (int j = i; j < dp[0].length; j++) {
				if(i == j) {
					dp[i][j] = sum - 2*nums[i];
					if(dp[i][j] == S) {
						res++;
					}
				}else {
					dp[i][j] = dp[i][j-1] - 2*nums[j];
					if(dp[i][j] == S) {
						res++;
					}
				}
				
			}
		}
		return res;
    }
	
	public static void main(String[] args) {
		int[] nums = {1, 1, 1, 1, 1};
		int S = 3;
		FindTargetSumWays F = new FindTargetSumWays();
		int res = F.findTargetSumWays(nums, S);
		System.out.println(res);
	}
}
