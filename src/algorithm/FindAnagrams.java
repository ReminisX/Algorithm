package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams {
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> L = new ArrayList<Integer>();
		if (s == null || p == null || s.length() < p.length()) {
            return L;
        }
		int[] counted = new int[p.length()];
		int index = 0;
		for (int i = 0; i < s.length(); i++) {
			
			for (int j = 0; j < p.length(); j++) {
				if(s.charAt(i) == p.charAt(j) && counted[j] == 0) {
					counted[j] = 1;
					if(this.summ(counted) == p.length()) {
						L.add(index);
					}
					break;
				}
				if(s.charAt(i) != p.charAt(j) && j == p.length()-1) {
					i += j;
					Arrays.fill(counted, 0);
					break;
				}
				
			}
			
		}
		return L;
    }
	
	public int summ(int[] nums) {
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			res += nums[i];
		}
		return res;
	}
	
	
	public static void main(String[] args) {
		FindAnagrams F = new FindAnagrams();
		String s = "abdefsdg";
		String p = "fed";
		List L = F.findAnagrams(s, p);
		System.out.println(L);
	}
	
	
	
	
}
