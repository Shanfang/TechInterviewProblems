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

// DP
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < S || -sum > S) {
            return 0;
        }

        int[][] dp = new int[nums.length][sum * 2 + 1];
        if (nums[0] == 0) {
            dp[0][sum] = 2;
        } else {
            dp[0][sum - nums[0]] = 1;
            dp[0][sum + nums[0]] = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < 2 * sum + 1; j++) {
                if (j - nums[i]>= 0) {
                    dp[i][j] += dp[i - 1][j - nums[i]];
                }
                if (j + nums[i] < 2 * sum + 1) {
                    dp[i][j] += dp[i - 1][j + nums[i]];
                }
            }
        }

        return dp[nums.length - 1][S + sum];
    }
}
