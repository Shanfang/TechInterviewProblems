class Solution {
    public int totalHammingDistance(int[] nums) {
        int total = 0;
        int len = nums.length;
        for (int i = 0; i < 32; i++) {
            int setBit = 0;
            for (int j = 0; j < len; j++) {
                setBit += (nums[j] >> i) & 1;
            }
            total += setBit * (len - setBit);
        }
        return total;
    }
}
