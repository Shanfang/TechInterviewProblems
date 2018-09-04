class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }

        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            count += smallerTwoSum(nums, i + 1, target - nums[i]); // find b + c < t - a
        }
        return count;
    }

    private int smallerTwoSum(int[] nums, int start, int target) {
        int i = start, j = nums.length - 1;
        int num = 0;
        while (i < j) {
            if (nums[i] + nums[j] < target) {
                num += (j - i);
                i++;
            } else if (nums[i] + nums[j] >= target){
                j--;
            }
        }
        return num;
    }
}
