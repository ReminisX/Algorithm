package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountSmaller {
	
	/*
	 * function 1: simply solution
	 */
    public List<Integer> countSmaller1(int[] nums) {
    	int len = nums.length;
    	List<Integer> counts = new ArrayList<Integer>();
    	
    	for(int i = 0; i < len; i++) {
    		int k = 0;
    		for(int j = i+1; j < len; j++) {
    			if(nums[i] > nums[j]) {
    				k++;
    			}
    		}
    		counts.add(k);
    	}
		return counts;
    }
    
	/*
	 * function 2: insert sort solution
	 */
    public List<Integer> countSmaller2(int[] nums){
    	List<Integer> counts = new ArrayList<Integer>();  //初始化结果表
    	if(nums.length == 0) {
    		return counts;
    	}
    	counts.add(0);
    	int k, temp;
    	int count = 0;
    	for(int i=nums.length-2; i>=0; i--) {
    		k = i;
    		while(k < nums.length-1) {
    			if(nums[k] > nums[k+1]) {
    				temp = nums[k+1];
    				nums[k+1] = nums[k];
    				nums[k] = temp;
    				k++;
    				count++;
    			}else {
    				break;
    			}
    		}
    		counts.add(count);
    		count = 0;
    	}
    	Collections.reverse(counts);
		return counts;
    }
    
    /*
     * test solution
     */
    public static void main(String[] args) {
    	CountSmaller C = new CountSmaller();
    	List<Integer> counts = new ArrayList<Integer>();
    	int[] nums = {1, 3, 5, 3, 2, 4};
    	counts = C.countSmaller1(nums);
    	System.out.println(counts);
    }
    
    
}
