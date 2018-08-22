class Solution {
    public int maxProfit(int[] prices, int fee) {
        int cash = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }
}

// use a array to store profits, not space efficient but easy to understand
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[] sold = new int[prices.length];
        int[] hold = new int[prices.length];
        sold[0] = 0;
        hold[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            sold[i] = Math.max(sold[i - 1], hold[i - 1] + prices[i] - fee);
            hold[i] = Math.max(hold[i - 1], sold[i -1] - prices[i]);
        }
        return sold[prices.length - 1];
    }
}
