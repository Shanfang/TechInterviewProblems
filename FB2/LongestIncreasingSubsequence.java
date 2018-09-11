// O(NlogN) with binary search to find the insertion position
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int len = 0; // len is the next available space to put the next larger number
        for (int num : nums) {
            int pos = Arrays.binarySearch(dp, 0, len, num);
            if (pos < 0) {
                pos = -(pos + 1);
            }
            dp[pos] = num;
            if (pos == len) {
                len++;
            }
        }
        return len;
    }
}
// O(N^2) time complexity
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
