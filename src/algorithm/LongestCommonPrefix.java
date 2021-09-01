package algorithm;

/**
 * @author ZhangXiaodong
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0 || strs == null){
            return "";
        }
        StringBuilder s = new StringBuilder(strs[0]);
        for (int i = 1; i < strs.length; i++) {
            if(s.length() > strs[i].length()){
                s.delete(strs[i].length(), s.length());
            }
            for (int j = 0; j < Math.min(s.length(), strs[i].length()); j++) {
                if(s.charAt(j) != strs[i].charAt(j)){
                    s.delete(j, s.length());
                    break;
                }
            }
        }
        return s.toString();
    }

    public static void main(String[] args) {
        LongestCommonPrefix L = new LongestCommonPrefix();
        String[] strs = new String[2];
        strs[0] = "ab";
        strs[1] = "a";
        String res = L.longestCommonPrefix(strs);
        System.out.println(res);
    }

}
