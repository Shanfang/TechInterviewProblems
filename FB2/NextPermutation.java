class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int i = nums.length - 2;
        while (i >= 0) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
            i--;
        }
        if (i < 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        int j = nums.length - 1;
        while (j > i) {
            if (nums[j] > nums[i]) {
                break;
            }
            j--;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

        reverse(nums, i + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
