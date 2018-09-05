class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int maxP = 0;
        int len = prices.length;
        int[] hold = new int[len];
        int[] sold = new int[len];
        hold[0] = -prices[0];
        sold[0] = 0;
        for (int i = 1; i < len; i++) {
            hold[i] = Math.max(sold[i - 1] - prices[i], hold[i - 1]);
            sold[i] = Math.max(sold[i - 1], hold[i - 1] + prices[i] - fee);
        }
        return sold[len];
    }
}
