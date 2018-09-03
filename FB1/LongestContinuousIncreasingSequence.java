class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int start = 0, end = 1;
        int longest = 1;
        while (end < nums.length) {
            if (nums[end] > nums[end - 1]) {
                longest = Math.max(longest, end - start + 1);
            } else {
                start = end;
            }
            end++;
        }
        return longest;
    }
}
