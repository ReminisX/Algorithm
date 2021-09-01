package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CombinationSum {
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> listAll=new ArrayList<List<Integer>>();
        List<Integer> list=new ArrayList<Integer>();
        
        Arrays.sort(candidates);
        
        this.combinationsum(candidates, target, listAll, list, 0);
        
        return listAll;
    }
	
	public void combinationsum(int[] candidates, int target, List<List<Integer>> listAll, List<Integer> list, int nums) {
		if(target == 0) {
			listAll.add(list);
			return;
		}
		
		if(target < candidates[0]) {
			return;
		}
		
		for(int i = nums; i < candidates.length && target >= candidates[i]; i++) {
			List<Integer> l = new ArrayList(list);
			l.add(candidates[i]);
			this.combinationsum(candidates, target-candidates[i], listAll, l, i);
		}
	}
	
	public static void main(String[] args) {
		int[] candidates = {2, 3, 4, 7};
		int target = 10;
		CombinationSum C = new CombinationSum();
		List<List<Integer>> L = C.combinationSum(candidates, target);
		for(List<Integer> l : L) {
			System.out.println(l);
		}
	}
	
	
}
