package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ten {
	public int[] ten(List<List<Integer>> nums) {
		int[] h = new int[nums.size()];
		int[] l = new int[nums.size()];
		
		for(int i = 0; i < nums.size(); i++) {
			h[i] = 0;
			l[i] = 0;
		}
		
		// 行累加
		for(int i = 0; i < nums.size(); i++) {
			for(int j = 0; j < nums.get(0).size(); j++) {
				h[i] += nums.get(i).get(j);
			}
		}
		// 列累加
		for(int j = 0; j < nums.get(0).size(); j++) {
			for(int i = 0; i < nums.size(); i++) {
				l[j] += nums.get(i).get(j);
			}
		}
		
		// 中心点去除
		int max = 0;
		int h_max_index = 0;
		int l_max_index = 0;
		for(int i = 0; i < nums.size(); i++) {
			for(int j = 0; j < nums.size(); j++) {
				if(h[i] + l[j] - nums.get(i).get(j) > max) {
					max = h[i] + l[j] - nums.get(i).get(j);
					h_max_index = i;
					l_max_index = j;
				}
			}
		}
		
		int[] result = new int[2];
		result[0] = h_max_index;
		result[1] = l_max_index;
		
		return result;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		
		List<List<Integer>> nums = new ArrayList<List<Integer>>();
		for(int i = 0; i < n; i++) {
			String S = sc.nextLine();
			String[] s = S.split(" ");
			ArrayList<Integer> A = new ArrayList<Integer>();
			for(int j = 0; j < n; j++) {
				A.add(Integer.parseInt(s[j]));
			}
			nums.add(A);
		}
		
		Ten T = new Ten();
		
		while(nums.size() != 0) {
			
			int[] result = T.ten(nums);
			int a = result[0] + 1;
			int b = result[1] + 1;
			System.out.println(a + " " + b);
			nums.remove(result[0]);
			for(int i = 0; i < nums.size(); i++) {
				nums.get(i).remove(result[1]);
			}
		}
		
	}
}
