package algorithm;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int left = 0;
        int right = 0;
        int res = 0;
        Set<Character> set = new HashSet<>();
        while(right < s.length()){
            char c = s.charAt(right);
            if(set.contains(c)){
                while(s.charAt(left) != c){
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
            }else{
                set.add(c);
            }
            right++;
            int max = right - left;
            res = max > res ? max : res;
        }
        return res;
    }

}
