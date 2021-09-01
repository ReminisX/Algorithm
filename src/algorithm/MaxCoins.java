package algorithm;

public class MaxCoins {
	public int maxCoins(int[] nums) {
		int n = nums.length;
		// 定义拓展数组
		int[] NUMS = new int[n+2];
		for (int i = 0; i < n; i++) {
			NUMS[i+1] = nums[i];
		}
		NUMS[0] = 1;
		NUMS[n+1] = 1;
		// 定义动态规划矩阵
        int[][] matrix = new int[n+2][n+2];
        for (int k = 1; k <= n; k++) {
        	for (int i = 0; i < n-k+1; i++) {
    			int j = i + k + 1;
    			for (int x = i+1; x < j; x++) {
					matrix[i][j] = Math.max(matrix[i][j], matrix[i][x] + NUMS[i]*NUMS[x]*NUMS[j] + matrix[x][j]);
				}
    		}
		}
        return matrix[0][n+1];
    }
	
	public static void main(String[] args) {
		int[] nums = {3,1,5,8};
		MaxCoins M = new MaxCoins();
		int res = M.maxCoins(nums);
		System.out.println(res);
	}
}
