class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int maxP = 0;
        for (int i = 1; i < prices.length; i++) {
            int profit = 0;
            if (prices[i] > prices[i - 1]) {
                maxP += prices[i] - prices[i - 1];
            }
        }
        return maxP;
    }
}

// find peak and vally
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int maxP = 0;
        int peak = prices[0];
        int vally = prices[0];
        int i = 1;
        while (i < prices.length) {
            while (i < prices.length && prices[i] <= prices[i - 1]) {
                i++;
            }
            vally = prices[i - 1];
            while (i < prices.length && prices[i] >= prices[i - 1]) {
                i++;
            }
            peak = prices[i - 1];
            maxP += peak - vally;
        }
        return maxP;
    }
}
