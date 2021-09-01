package algorithm;

public class MinDistance {
	public int minDistance(String word1, String word2) {
		// Ϊ������ж�
        if (word1 == null || word2 == null) {
            return 0;
        }
        // �߽�ֵȷ��
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= word2.length(); i++) {
            dp[0][i] = i;
        }
        // ��Ҫ����ѭ��
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j], dp[i + 1][j]), dp[i][j + 1]) + 1;
                }
            }
        }
        // �������Ľ��ֵ
        return dp[word1.length()][word2.length()];
    }
	
	public static void main(String[] args) {
		String word1 = "abcdefg";
		String word2 = "dfgea";
		MinDistance M = new MinDistance();
		int k = M.minDistance(word1, word2);
		System.out.println(k);
	}
}
