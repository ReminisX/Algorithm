package algorithm;

import java.util.HashMap;
import java.util.Map;

public class ClimbStairs {
	private static Map<Integer, Integer> m = new HashMap<Integer, Integer>();
	// 动态规划（自顶向下）
	public int climbStairs(int n) {
		if(n == 0) {
			return 0;
		}
		if(n == 1) {
			return 1;
		}
		if(n == 2) {
			return 2;
		}
		
		if(m.containsKey(n)) {
			return m.get(n);
		}else {
			m.put(n, this.climbStairs(n-1)+this.climbStairs(n-2));
			return this.climbStairs(n-1)+this.climbStairs(n-2);
		}
	}
	
	public static void main(String[] args) {
		ClimbStairs C = new ClimbStairs();
		int n = 5;
		int m = C.climbStairs(n);
		System.out.println(m);
	}
}
