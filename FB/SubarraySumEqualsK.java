/*
The brute force approach is to try different pairs of (start, end) index.

To make it more efficient, we try different end index, while only try those potential start index.
Actually, we are not trying to see it each start index works or not. Using a hashmap, we can get the
number of different start indexes with prefix sum equals prefix[endIdx] - k.

This is kinda of memorization in DP.
*/
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
