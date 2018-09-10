class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        int maxLen = 1;
        for (int i = 1; i < len; i++) {
            int tempMax = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    tempMax = Math.max(dp[j], tempMax);
                }
            }
            dp[i] = tempMax + 1;
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}
