// divide and conquer
class Solution {
    public int majorityElement(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private int helper(int[] nums, int low, int high) {
        if (low == high) {
            return nums[low];
        }

        int mid = low + (high - low) / 2;
        int lowPart = helper(nums, low, mid);
        int highPart = helper(nums, mid + 1, high);

        if (lowPart == highPart) {
            return lowPart;
        }
        int lowCount = count(nums, low, mid, lowPart);
        int highCount = count(nums, mid + 1, high, highPart);
        return lowCount > highCount ? lowPart : highPart;
    }

    private int count (int[] nums, int i, int j, int target) {
        int count = 0;
        for (int k = i; k <= j; k++) {
            if (nums[k] == target) {
                count++;
            }
        }
        return count;
    }
}
