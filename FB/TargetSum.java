class Solution {
    int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum < S || S < -sum) {
            return 0;
        }

        findSubTarget(nums, sum, S, 0);
        return count;
    }

    private void findSubTarget(int[] nums, int sum, int target, int index) {
        if (sum == target) {
            count++;
        }

        for (int i = index; i < nums.length; i++) {
            sum -= 2 * nums[i];
            findSubTarget(nums, sum, target, i + 1);
            sum += 2 * nums[i];
        }
    }
}
