// quick select with average linear time complexity
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int i = 0, j = nums.length - 1;
        while (true) {
            int partition = quickSelect(nums, i, j);
            if (partition == k - 1) {
                return nums[partition];
            } else if (partition > k - 1) {
                j = partition - 1;
            } else {
                i = partition + 1;
            }
        }
    }

    private int quickSelect(int[] nums, int start, int end) {
        int pivot = nums[start];
        int index = start + 1;
        while (index <= end) {
            if (nums[index] < pivot && nums[end] > pivot) {
                swap(nums, index, end);
                index++;
                end--;
            }
            if (nums[index] >= pivot) {
                index++;
            }
            if (nums[end] <= pivot) {
                end--;
            }
        }
        swap(nums, start, end);
        return end;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
