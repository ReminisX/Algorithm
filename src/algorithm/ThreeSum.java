package algorithm;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	
    	for(int i = 0; i < nums.length; i++) {
    		for(int j = i+1; j < nums.length; j++) {
    			for(int k = j+1; k < nums.length; k++) {
    				if(nums[i] + nums[j] + nums[k] == 0) {
    					List<Integer> L = new ArrayList<Integer>();
    					L.add(nums[i]);
    					L.add(nums[j]);
    					L.add(nums[k]);
    					Collections.sort(L);
    					if(result.size() == 0) {
    						result.add(L);
    					}
    					for(int z = 0; z < result.size(); z++) {
    						if(result.get(z).get(0) == L.get(0) && result.get(z).get(1) == L.get(1) && result.get(z).get(2) == L.get(2)) {
    							break;
    						}
    						if(z == result.size()-1) {
    							result.add(L);
    						}
    					}
    				}
    			}
    		}
    	}
    	
    	return result;
    }
    
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return list;
        }
        // 先排序，同时避免求重复解
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2 && nums[i] <= 0;) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[l++], nums[r--]));
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                    while (r > l && nums[r] == nums[r + 1]) {
                        r--;
                    }
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
            i++;
            while (i < nums.length - 2 && nums[i] == nums[i - 1]) {
                i++;
            }
        }
        return list;
    }
    
    public static void main(String args[]) {
    	ThreeSum T = new ThreeSum();
    	int[] nums = {-1,0,1,2,-1,-4};
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	result = T.threeSum2(nums);
    	System.out.println(result);
    }
    
}
