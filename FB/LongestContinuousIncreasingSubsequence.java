class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxLen = 1;
        int preLen = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                preLen++;
            } else {
                preLen = 1;
            }
            maxLen = Math.max(preLen, maxLen);
        }
        return maxLen;
    }
}
