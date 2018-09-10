class Solution {
    public int reversePairs(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public int helper(int[] nums, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int count = 0;
        int mid = start + (end - start) / 2;
        count = helper(nums, start, mid) + helper(nums, mid + 1, end);

        int i = start, j = mid + 1;
        int p = mid + 1, k = 0;
        int[] merged = new int[end - start + 1];

        while (i <= mid) {
            while (p <= end && nums[i] > 2L * nums[p]) { // need to add suffix L to indicate it is long type
                p++;
            }
            count += p - mid - 1;

            // merge sort subarray
            while (j <= end && nums[i] >= nums[j]) {
                merged[k++] = nums[j++];
            }
            merged[k++] = nums[i++];
        }
        while (j <= end) {
            merged[k++] = nums[j++];
        }
        System.arraycopy(merged, 0, nums, start, merged.length);
        return count;
    }
}
