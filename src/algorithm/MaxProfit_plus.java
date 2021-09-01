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
			// ֱ������������������� = MAX��ֱ������������������ + ����ļ۸� ֱ������������������棩
			sell[i] = Math.max(buy[i-1] + prices[i], sell[i-1]);
			// ֱ������������������ = MAX��ֱ�������䶳�ڵ�������� - ����ļ۸� ֱ�����������������棩
			buy[i] = Math.max(cold[i-1]-prices[i], buy[i-1]);
			// ֱ�������䶳�ڵ�������� = MAX��ֱ�������䶳�ڵ�������룬 ֱ������������������棩
			cold[i] = Math.max(cold[i-1], sell[i-1]);
		}
		return Math.max(sell[prices.length-1], cold[prices.length-1]);
    }
}
