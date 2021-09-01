package algorithm;

public class MaxProfit_plus {
	public int maxProfit(int[] prices) {
		if(prices.length == 0){
            return 0;
        }
		int[] sell = new int[prices.length];
		int[] buy = new int[prices.length];
		int[] cold = new int[prices.length]; 
		buy[0] = - prices[0];
		for (int i = 1; i < prices.length; i++) {
			// 直至今天卖出的最大收益 = MAX（直至昨天买进的最大收益 + 今天的价格， 直至昨天卖出的最大收益）
			sell[i] = Math.max(buy[i-1] + prices[i], sell[i-1]);
			// 直至今天买进的最大收益 = MAX（直至昨天冷冻期的最大收益 - 今天的价格， 直至昨天买进的最大收益）
			buy[i] = Math.max(cold[i-1]-prices[i], buy[i-1]);
			// 直至今天冷冻期的最大收益 = MAX（直至昨天冷冻期的最大收入， 直至昨天卖出的最大收益）
			cold[i] = Math.max(cold[i-1], sell[i-1]);
		}
		return Math.max(sell[prices.length-1], cold[prices.length-1]);
    }
}
