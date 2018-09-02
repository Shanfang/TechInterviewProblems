class Solution {
    public boolean canJump(int[] nums) {
        int lastLeftmost = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i >= lastLeftmost) {
                lastLeftmost = i;
            }
        }
        return lastLeftmost == 0;
    }
}
