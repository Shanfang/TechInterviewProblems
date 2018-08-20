class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxLen = 1;
        int[] LIS = new int[nums.length];
        LIS[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            int len = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    len = Math.max(len, LIS[j] + 1);
                }
            }
            LIS[i] = len;
            maxLen = Math.max(maxLen, LIS[i]);
        }
        return maxLen;
    }
}
