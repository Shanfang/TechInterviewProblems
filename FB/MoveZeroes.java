class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[left];
                nums[left] = nums[i];
                nums[i] = temp;
                left++;
            }
        }
    }
}

/* template for two pointers with left edge starting from -1
    for remove duplicate from sorted array, we need to start from index 0,
    as we need to access array for the number at that index 
*/
class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int leftIdx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[++leftIdx];
                nums[leftIdx] = nums[i];
                nums[i] = temp;
            }
        }
    }
}
