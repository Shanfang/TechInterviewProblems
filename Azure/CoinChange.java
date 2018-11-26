class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        int[] change = new int[amount + 1];
        Arrays.fill(change, amount + 1); // to get rid of overflow problem in the following if statement
        change[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    change[i] = Math.min(change[i], change[i - coin] + 1);
                }
            }
        }
        return change[amount] > amount ? -1 : change[amount];
    }
}
