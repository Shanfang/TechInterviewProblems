class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int i = 0, left = 0, right = nums.length - 1;
        while (i <= right){
            if (nums[i] == 0) {
                swap(nums, left, i);
                i++;
                left++;
            } else if (nums[i] == 2) {
                swap(nums, right, i);
                right--;
            } else {
                i++;
            }
        }
    }
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
