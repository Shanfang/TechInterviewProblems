// slide window
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int start = 0, end = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        while (end < nums.length) {
            sum += nums[end];
            end++;

            while (sum >= s) {
                minLen = Math.min(minLen, end - start);
                sum -= nums[start];
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
// O(N) time complexity with two pointers
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0, i = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        while (i < nums.length) {
            sum += nums[i];
            while (sum >= s) {
                minLen = Math.min(i - left + 1, minLen);
                sum -= nums[left];
                left++;
            }
            i++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
// O(N^2) with prefix sum
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] preSum = new int[nums.length];
        preSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }

        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (preSum[j] - preSum[i] + nums[i] >= s) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
