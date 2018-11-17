// bit voting
class Solution {
    public int majorityElement(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int mask = 1 << i;
            int votes = 0;
            for (int j = 0; j < nums.length; j++) {
                // System.out.println(nums[j] & mask); this bit is 1, but the number is not 1!!!
                if ((nums[j] & mask) != 0) {
                    votes++;
                }
            }
            if (votes > nums.length / 2) {
                result |= mask;
            }
        }
        return result;
    }
}
