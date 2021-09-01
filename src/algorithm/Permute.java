package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Permute {
	
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		int[] used = new int[nums.length];
		if(nums.length == 0) {
			return lists;
		}
		for(int i = 0; i < nums.length; i++) {
			used[i] = 0;
		}
		
		this.mute(lists, list, nums, used);
		
		return lists;
    }
	
	public void mute(List<List<Integer>>lists, List<Integer> list, int[] nums, int[] used) {
		if(list.size() == nums.length) {
			lists.add(new ArrayList<Integer>(list));
			return;
		}
		
		for(int i = 0; i < nums.length; i++) {
			if(used[i] == 1) {
				continue;
			}
			list.add(nums[i]);
			used[i] = 1;
			this.mute(lists, list, nums, used);
			used[i] = 0;
			list.remove(list.size()-1);
		}
		
	}
	
	public static void main(String[] args) {
		Permute P = new Permute();
		int[] nums = {1, 2, 3};
		List<List<Integer>> lists = P.permute(nums);
		for(List<Integer> l : lists) {
			System.out.println(l);
		}
	}
	
}
