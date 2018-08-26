// use priority queue
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}


// use quick select
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        while (true) {
            int position = quickSelect(nums, start, end);
            if (position == k - 1) {
                return nums[position];
            } else if (position > k - 1) {
                end = position - 1;
            } else {
                start = position + 1;
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
