class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1){
            return 0;
        }
        if (nums.length == 2) {
            return nums[0] > nums[1] ? 0 : 1;
        }

        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] < nums[mid - 1]) {
                right = mid;
            } else  {
                left = mid;
            }
        }
        return nums[left] > nums[right] ? left : right;
    }
}
