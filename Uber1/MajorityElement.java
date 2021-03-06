// bit voting
class Solution {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        int majority = 0;
        for (int i = 0; i < 32; i++) {
            int mask = 1 << i;
            int count = 0;
            for (int num : nums) {
                if ((num & mask) != 0) {
                    count++;
                }
            }
            if (count > len / 2) {
                majority |= mask; // make this bit 1
            }
        }
        return majority;
    }
}

// Boyer-Moore Voting Algorithm
class Solution {
    public int majorityElement(int[] nums) {
        int count = 1;
        int majority = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == majority) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    majority = nums[i];
                    count = 1;
                }
            }
        }
        return majority;
    }
}

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
