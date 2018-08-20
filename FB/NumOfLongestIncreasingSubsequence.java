class Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] maxLens = new int[nums.length];
        int[] counts = new int[nums.length];
        maxLens[0] = 1;
        counts[0] = 1;
        int maxLen = 1;
        for (int i = 1; i < nums.length; i++) {
            maxLens[i] = 1;
            counts[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (maxLens[i] == maxLens[j] + 1) {
                        counts[i] += counts[j];
                    }
                    if (maxLens[i] < maxLens[j] + 1) {
                        maxLens[i] = maxLens[j] + 1;
                        counts[i] = counts[j];
                    }
                }
            }
            maxLen = Math.max(maxLen, maxLens[i]);
        }

        int count = 0;
        for (int i = 0; i < maxLens.length; i++) {
            if (maxLens[i] == maxLen) {
                count += counts[i];
            }
        }
        return count;
    }
}
