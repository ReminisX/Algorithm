package algorithm;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || "".equals(s)) {
            return true;
        }
        
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String sub = s.substring(j, i);
                if (dp[j] && wordDict.contains(sub)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
	
	public static void main(String[] args) {
		WordBreak W = new WordBreak();
		List<String> L = new ArrayList<String>();
		String s = "cars";
		L.add("car");
		L.add("ca");
		L.add("rs");
		boolean b = W.wordBreak(s, L);
		System.out.println(b);
	}
	
}
