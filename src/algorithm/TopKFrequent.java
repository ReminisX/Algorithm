package algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequent {
	public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> m = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
			m.put(nums[i], m.getOrDefault(nums[i], 0)+1);
		}
        return m.entrySet()
                .stream()
                .sorted((m1, m2) -> m2.getValue() - m1.getValue())
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }
}
