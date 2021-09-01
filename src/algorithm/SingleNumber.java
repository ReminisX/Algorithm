package algorithm;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {
	// 集合判断元素是否存在
	public int singleNumber(int[] nums) {
		
		Set<Integer> S = new HashSet<Integer>();
		
		for (int i = 0; i < nums.length; i++) {
			if(S.contains(nums[i])) {
				S.remove(nums[i]);
			}else {
				S.add(nums[i]);
			}
		}
		int r = (int) S.toArray()[0];
		return r;
    }
	// 异或进行元素的判断
	public int singleNumber2(int[] nums) {
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			result = result ^ nums[i];
		}
		return result;
	}
	
	public static void main(String[] args) {
		SingleNumber S = new SingleNumber();
		int[] nums = {1, 2, 2, 3, 3, 1, 6};
		int k = S.singleNumber2(nums);
		System.out.println(k);
	}
	
}
