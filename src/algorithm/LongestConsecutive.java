package algorithm;

import java.util.Arrays;

public class LongestConsecutive {
	public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int max = 1;
        int MAX = 1;
        if(nums.length == 1) {
        	return 1;
        }
        if(nums.length == 0) {
        	return 0;
        }
        for (int i = 1; i < nums.length; i++) {
        	if(nums[i] == nums[i-1]) {
        		continue;
        	}
			if(nums[i] == nums[i-1] + 1 || nums[i] == nums[i-1] - 1) {
				max++;
				if(MAX < max) {
					MAX = max;
				}
			}else {
				if(MAX < max) {
					MAX = max;
				}
				max = 1;
			}
		}
        return MAX;
    }
	
	public static void main(String[] args) {
		LongestConsecutive L = new LongestConsecutive();
		int[] nums = {0, 0};
		int k = L.longestConsecutive(nums);
		System.out.println(k);
	}
}
