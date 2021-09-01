package algorithm;

import java.util.Arrays;

public class CoinChange {
	public int coinChange(int[] coins, int amount) {
		int[] mounts = new int[amount];
		Arrays.fill(mounts, Integer.MAX_VALUE);
		for (int i : coins) {
			mounts[i-1] = 1;
		}
		for (int i = 0; i < mounts.length; i++) {
			for (int j = 0; j < coins.length; j++) {
				if(i - coins[j] < 0) {
					continue;
				}else {
					int temp = mounts[i-coins[j]] + 1;
					if(mounts[i] > temp) {
						mounts[i] = temp;
					}
				}
			}
		}
		if(mounts[amount-1] > 10000 || mounts[amount-1] < 0) {
			return -1;
		}else {
			return mounts[amount-1];
		}
    }
	
	public static void main(String[] args) {
		CoinChange C = new CoinChange();
		int[] coins = {1, 2, 5};
		int amount = 11;
		int res = C.coinChange(coins, amount);
		System.out.println(res);
	}
}
