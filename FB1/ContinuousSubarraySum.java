class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if (k != 0) {
                nums[i] = nums[i] % k;
            }
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) >= 2) {
                    return true;
                }
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
}
