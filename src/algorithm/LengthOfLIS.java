package algorithm;

import java.util.Arrays;

public class LengthOfLIS {
	public int lengthOfLIS(int[] nums) {
		if(nums == null || nums.length == 0){
            return 0;
        }
        int[] counts = new int[nums.length];
        int res = 1;
        Arrays.fill(counts, 1);
        for (int i = counts.length-2; i >= 0; i--) {
        	int max = 0;
			for (int j = i+1; j < counts.length; j++) {
				if(nums[i] < nums[j] && max < counts[j] + 1) {
					max = counts[j] + 1;
					counts[i] = max;
					res = Math.max(res, max);
				}
			}
		}
        System.out.println("สýื้ฮชฃบ");
        for(int x : counts) {
        	System.out.print(x + " ");
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		LengthOfLIS L =new LengthOfLIS();
		int[] nums = {10,9,2,5,3,7,101,18};
		int res = L.lengthOfLIS(nums);
		System.out.println("\n" +"the result is :" + res);
	}
}
