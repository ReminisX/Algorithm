package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> L = new ArrayList<List<Integer>>();
		// 加入空集
		L.add(new ArrayList<Integer>(Arrays.asList()));
		// 循环添加子集
		for(int i = 0; i < nums.length; i++) {
			int list_size = L.size();
			for(int j = 0; j < list_size; j++) {
				List<Integer> l = new ArrayList<Integer>(L.get(j));
				l.add(nums[i]);
				L.add(l);
			}
		}
		return L;
    }
	
	public static void main(String[] args) {
		Subset S = new Subset();
		int[] nums = {1, 2, 3, 4};
		List<List<Integer>> L = S.subsets(nums);
		System.out.println(L);
	}
	
}
