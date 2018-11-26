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
