class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length <  2) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            twoSum(-nums[i], i + 1, nums, result);
        }
        return result;
    }

    private void twoSum(int target, int start, int[] nums, List<List<Integer>> result) {
        int end = nums.length - 1;
        while (start < end) {
            if (nums[start] + nums[end] == target) {
                List<Integer> list = new ArrayList<>();
                list.add(-target);
                list.add(nums[start]);
                list.add(nums[end]);
                result.add(list);
                start++;
                end--;
                while (start < end && nums[start] == nums[start - 1]) {
                    start++;
                }
                while (start < end && nums[end] == nums[end + 1]) {
                    end--;
                }
            } else if (nums[start] + nums[end] < target) {
                start++;
            } else {
                end--;
            }
        }
    }
}
