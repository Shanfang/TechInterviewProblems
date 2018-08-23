class Solution {
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        nums[0] = nums[0] == 0 ? -1 : nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
            nums[i] += nums[i - 1];
        }
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // prefixSum, index
        for (int i = 0; i < nums.length; i++ ) {
            if (map.containsKey(nums[i])) {
                maxLen = Math.max(maxLen, i - map.get(nums[i]));
            } else {
                map.put(nums[i], i);
            }
        }
        return maxLen;
    }
}
