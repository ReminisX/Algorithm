package algorithm;

import java.util.ArrayList;
import java.util.List;

public class MaxProduct {
	public int maxProduct(int[] nums) {
		int res = nums[0];
        int max = 1;
        int min = 1;
        for (int num : nums) {
        	// 若小于0，则互换max与min的值
            if (num < 0) {
                int temp = min;
                min = max;
                max = temp;
            }
            // 主要累乘值
            max = Math.max(max * num, num);
            // 负数保存值
            min = Math.min(min * num, num);
            // 结果值
            res = Math.max(max, res);
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		int[] nums = {2, 2, 3, -1, 2, 2, 3, 4};
		MaxProduct M = new MaxProduct();
		int r = M.maxProduct(nums);
		System.out.println(r);
	}
}
