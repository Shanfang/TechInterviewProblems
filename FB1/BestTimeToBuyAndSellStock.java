class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int profit = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                // each time we find a minPrice, only check against this minPrice for the following days, which guarantees the hight prices from previous day are not checked against
                minPrice = prices[i]; 
            }
            profit = Math.max(profit, prices[i] - minPrice);
        }
        return profit;
    }
}
