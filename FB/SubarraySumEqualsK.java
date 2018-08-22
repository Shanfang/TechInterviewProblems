class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += map.getOrDefault(nums[i] - k, 0);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return count;
    }
}
