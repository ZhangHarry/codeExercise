package Algorithm.lintcode;

public class BestTimeBuySellWithTransactionFee {
	 /**
     * @param prices: a list of integers
     * @param fee: a integer
     * @return: return a integer
     */
    public int maxProfit(int[] prices, int fee) {
        // write your code here
        if (prices.length <= 1)
            return 0;
        int profile = 0;
        int buy = prices[0], sell = buy;
        for (int i=1; i<prices.length; i++){
        	if (prices[i] >= sell)
                sell = prices[i];
            else if (prices[i] < buy){
                buy = sell = prices[i];
            }
            else {
                if (sell-buy-fee > 0){
                    profile += sell-buy-fee;
                    buy = sell = prices[i];
                }
            }
        }
        profile += sell-buy-fee > 0? sell-buy-fee:0;
        return profile;
    }
    
    public static void main(String[] args) {
    	BestTimeBuySellWithTransactionFee test = new BestTimeBuySellWithTransactionFee();
    	int[] prices = new int[]{
    		4,5,2,4,3,3,1,2,5,4
    	};
    	int fee = 1;
    	System.out.println(test.maxProfit(prices, fee));
    	prices = new int[]{
        		2,1,4
        	};
    	System.out.println(test.maxProfit(prices, fee));
	}
}
