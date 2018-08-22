class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); //(key, val) -> (prefixSum, index)

        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            if (k != 0) {
                nums[i] = nums[i] % k;
            }
            if (map.containsKey(nums[i])) {
                int idx = map.get(nums[i]);
                if (i - idx > 1) {
                    return true;
                }
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
}
