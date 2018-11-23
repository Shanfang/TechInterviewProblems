class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i - 1]) { // or check nums[i] != nums[index]
                nums[++index] = nums[i];
                count = 1;
            } else {
                if (count < 2) {
                    nums[++index] = nums[i];
                    count++;
                }
            }
        }
        return index + 1;
    }
}
