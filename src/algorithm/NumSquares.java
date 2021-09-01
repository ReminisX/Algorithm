package algorithm;

import java.util.Arrays;

public class NumSquares {
	public int numSquares2(int n) {
        if(Math.sqrt(n) - (int)Math.sqrt(n) == 0) {
        	return 1;
        }
        
        int count = Integer.MAX_VALUE;
        for (int x = 1; x < n; x++) {
			int k = this.numSquares(x) + this.numSquares(n-x);
			if(count > k) {
				count = k;
			}
		}
        return count;
    }
	
	public int numSquares3(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 1; i * i <= n; i++) {
            dp[i * i] = 1;
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j * j + i <= n; j++) {
                dp[i + j * j] = Math.min(dp[i + j * j], dp[i] + 1);
            }
        }
        return dp[n];
    }
	
	public int numSquares(int n) {
		while(n % 4 == 0) {
			n /= 4;
		}
		if(n % 8 == 7) {
			return 4;
		}
		int a = 0;
		while(a*a <= n) {
			int b = (int)Math.sqrt(n - a*a);
			if(a*a + b*b == n) {
				if(a == 0 && b == 0) {
					return 0;
				}
				if(a != 0 && b != 0) {
					return 2;
				}else {
					return 1;
				}
			}
			a += 1;
		}
		return 3;
	}
	
	public static void main(String[] args) {
		NumSquares N = new NumSquares();
		int res = N.numSquares(213);
		System.out.println(res);
	}
}
