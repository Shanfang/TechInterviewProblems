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
