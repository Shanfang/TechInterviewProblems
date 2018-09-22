class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            twoSum(nums, i, result);
        }
        return result;
    }

    private void twoSum(int[] nums, int index, List<List<Integer>> result) {
        int start = index + 1;
        int end = nums.length - 1;
        while (start < end) {
            if (nums[index] + nums[start] + nums[end] == 0) {
                result.add(Arrays.asList(nums[index], nums[start], nums[end]));
                start++;
                end--;
                while (start < end && nums[start] == nums[start - 1]) {
                    start++;
                }
                while (start < end && nums[end] == nums[end + 1]) {
                    end--;
                }

            } else if (nums[index] + nums[start] + nums[end] > 0) {
                end--;
            } else {
                start++;
            }
        }
    }
}
