class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int len = prices.length;
        int[] sold = new int[len + 1];
        int[] hold = new int[len + 1];
        int[] rest = new int[len + 1];
        hold[0] = Integer.MIN_VALUE;
        sold[0] = 0;
        rest[0] = 0;
        for (int i = 0; i < prices.length; i++) {
            hold[i + 1] = Math.max(rest[i] - prices[i], hold[i]);
            sold[i + 1] = hold[i] + prices[i];
            rest[i + 1] = Math.max(rest[i], sold[i]);
        }
        return Math.max(sold[len], rest[len]);
    }
}
