package algorithm;

import java.util.ArrayList;
import java.util.List;

public class CountSmaller {
    public List<Integer> countSmaller(int[] nums) {
    	int len = nums.length;
    	List<Integer> counts = new ArrayList<Integer>();
    	
    	for(int i = 0; i < len; i++) {
    		int k = 0;
    		for(int j = i+1; j < len; j++) {
    			if(nums[i] > nums[j]) {
    				k++;
    			}
    			counts.add(k);
    		}
    	}
		return counts;
    }
}
