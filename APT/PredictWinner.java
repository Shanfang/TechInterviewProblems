class Solution {
    public boolean PredictTheWinner(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int len = nums.length;
        int[][] dp = new int[len][len];
        dp[len - 1][len - 1] = nums[len - 1];
        for (int i  = len - 2; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (i == j) {
                    dp[i][j] = nums[i];
                } else {
                    int pickLeft = nums[i] - dp[i + 1][j];
                    int pickRight = nums[j] - dp[i][j - 1];
                    dp[i][j] = Math.max(pickLeft, pickRight);
                }
            }
        }
        return dp[0][len - 1] >= 0;
    }
}
