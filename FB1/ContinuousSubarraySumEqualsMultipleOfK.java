class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(k != 0) {
                sum = sum % k;
            }
            if (map.containsKey(sum)) {
                // does not put new entry into map, does not return either if map contains the key but subarray size < 2
                 if (i - map.get(sum) > 1) {
                     return true;
                 }
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }
}