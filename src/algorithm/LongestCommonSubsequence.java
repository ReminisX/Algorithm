package algorithm;

/**
 * @author l
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();

        int m = t1.length;
        int n = t2.length;

        int[][] dp = new int[m+1][n+1];

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if(t1[i] == t2[j]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
