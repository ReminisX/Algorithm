package algorithm;

import java.util.ArrayList;
import java.util.List;

public class MaxProfit {
	public int maxProfit(int[] prices) {
		if(prices.length == 0){
            return 0;
        }
		int result = 0;
		int min = prices[0];
		for (int i = 0; i < prices.length; i++) {
			if(prices[i] - min > result) {
				result = prices[i] - min;
			}else if(prices[i] < min) {
				min = prices[i];
			}
		}
		return result;
    }
	
	public static void main(String[] args) {
		int[] prices = {7,1,5,3,6,4};
		MaxProfit M = new MaxProfit();
		int k = M.maxProfit(prices);
		System.out.println(k);
	}
}
