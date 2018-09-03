// at each index, find the longest increasing subsequence ending with current index
// keep a variable and update it while checking each possible ending index
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int longest = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) { // we can attach number at index i to the sequence ending at j
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            longest = Math.max(longest, dp[i]);
        }
        return longest;
    }
}


// O(NlogN) time complexity with binary search for the last ending index
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = 0;
        int[] dp = new int[nums.length];
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1); // because if a result is not in array, the above API return -(insertion point) – 1
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }
}
