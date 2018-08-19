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

// DP with memoization
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        // since we are guaranteed that sum < 1000, so even if all number are assigned neagative,
        // sum + 1000 > 0 is guaranteed
        int[][] memo = new int[nums.length][20001];
        for (int[] row : memo) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return find(nums, 0, 0, S, memo);
    }

    private int find(int[] nums, int index, int curSum, int target, int[][] memo) {
        if (index == nums.length) {
            if (curSum == target) {
                return 1;
            } else {
                return 0;
            }
        } else {
            if (memo[index][curSum + 1000] != Integer.MIN_VALUE) {
                return memo[index][curSum + 1000];
            }
            int positive = find(nums, index + 1, curSum + nums[index], target, memo);
            int negative = find(nums, index + 1, curSum - nums[index], target, memo);
            memo[index][curSum + 1000] = positive + negative;
        }
        return memo[index][curSum + 1000];
    }
}
