class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, 1);
        }

        helper(nums, new ArrayList<>(), map, result);
        return result;
    }

    private void helper(int[] nums, List<Integer> list, Map<Integer, Integer> map, List<List<Integer>> result) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == 0) {
                continue;
            }
            map.put(nums[i], 0);
            list.add(nums[i]);
            helper(nums,list, map, result);
            list.remove(list.size() - 1);
            map.put(nums[i], 1);
        }
    }
}
