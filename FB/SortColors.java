class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int left = 0, right = nums.length - 1;
        int index = 0;
        while (index <= right) {
            if (nums[index] == 0) {
                swap(nums, left, index);
                left++;
                index++;
            } else if (nums[index] == 1) {
                index++;
            } else {
                swap(nums, index, right);
                right--;
            }
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
