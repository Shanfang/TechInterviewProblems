class Solution {
    public int splitArray(int[] nums, int m) {
        if (nums == null || nums.length == 0 || nums.length < m) {
            return 0;
        }

        int len = nums.length;
        int[][] dp = new int[len + 1][m + 1];
        int[] sum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        for (int[] array : dp) {
            Arrays.fill(array, Integer.MAX_VALUE);
        }

        dp[0][0] = 0;
        for (int i = 1; i <= len; i++) { // for the range of [0, i+1] inclusive
            for (int j = 1; j <= m; j++) { // split into j groups
                for (int k = 0; k < i; k++) { //update dp[i][j] for every trial of spliting index k
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], sum[i] - sum[k]));
                }
            }

        }
        return dp[len][m];
    }
}
