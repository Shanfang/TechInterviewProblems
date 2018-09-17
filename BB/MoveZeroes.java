class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int start = 0, end = 0;
        while (end < nums.length) {
            if (nums[end] != 0) {
                swap(nums, start, end);
                start++;
            }
            end++;
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
