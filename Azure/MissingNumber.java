// use binary search
class Solution {
    public int missingNumber(int[] nums) {
        int left = 0, right = nums.length;
        Arrays.sort(nums);
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

// bit manipulation with XOR
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int result = n;
        for (int i = 0; i < n; i++) {
            result ^= nums[i] ^ i;
        }
        return result;
    }
}

// subtract from sum
class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int sum = (0 + len) * (len + 1) / 2;
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }
}
