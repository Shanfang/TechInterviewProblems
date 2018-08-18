class Solution {
    private int count = 0;

    public int findTargetSumWays(int[] nums, int S) {
        if (numS == null || nums.length == 0) {
            return 0;
        }

        int sum = 0;
        for (int i: nums) {
            sum += i;
        }
        if (sum < S) {
            return 0;
        }

        findSubtracted(nums, sum, 0, S);

        return count;
    }

    private void findSubtracted(int[] nums, int sum, int startIndex, int S) {
        if (sum == S) {
            count++;
        }
        for (int i = startIndex; i < nums.length; i++) {
            sum -= 2*nums[i];
            findSubtracted(nums, sum, i + 1, S);
            sum += 2*nums[i];
        }
    }
}
