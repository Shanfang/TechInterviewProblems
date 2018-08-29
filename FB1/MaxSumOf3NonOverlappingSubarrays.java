class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int len = nums.length;
        int[] sum = new int[len];
        sum[0] = nums[0];

        // get sum of each subarray with size k
        for (int i = 1; i < len; i++) {
            sum[i] = sum[i - 1] + nums[i];
            if (i >= k) {
                sum[i] -= nums[i - k];
            }
        }

        int[] left = new int[len];
        // mark the max end index from left
        int leftMaxIdx = k - 1;
        for (int i = k - 1; i < len; i++) {
            left[i] = sum[i] > sum[leftMaxIdx] ? i : leftMaxIdx;
            leftMaxIdx = left[i];
        }

        int[] right = new int[len];
        int rightMaxIdx = len - 1;
        for (int i = len - 1; i >= k - 1; i--) {
            right[i] = sum[i] > sum[rightMaxIdx] ? i : rightMaxIdx;
            rightMaxIdx = right[i];
        }

        int[] result = new int[3];
        int maxSum = Integer.MIN_VALUE;
        for (int i = 2 * k - 1; i < len - k; i++) {
            int threeMaxSum = sum[i] + sum[left[i - k]] + sum[right[i + k]];
            if (threeMaxSum > maxSum) {
                maxSum = threeMaxSum;
                result[0] = left[i - k] - k + 1;
                result[1] = i - k + 1;
                result[2] = right[i + k] - k + 1;
            }
        }
        return result;
    }
}
