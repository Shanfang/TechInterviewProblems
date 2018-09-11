class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int len = nums.length;
        boolean[] dp = new boolean[len];
        dp[len - 1] = true;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j <= Math.min(len - 1, i + nums[i]); j++) {
                if (dp[j]) {
                    dp[i] = true;
                }
            }
        }
        return dp[0];
    }
}
