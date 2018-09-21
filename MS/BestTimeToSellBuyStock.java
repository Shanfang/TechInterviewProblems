class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int maxP = 0;
        int minPrice = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            }
            maxP = Math.max(prices[i] - minPrice, maxP);
        }
        return maxP;
    }
}
