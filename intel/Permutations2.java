class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        helper(nums, map, new ArrayList<>(), result);
        return result;
    }

    private void helper(int[] nums, Map<Integer, Integer> map, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int num : map.keySet()) {
            if (map.get(num) > 0) {
                map.put(num, map.get(num) - 1);
                list.add(num);
                helper(nums, map, list, result);
                list.remove(list.size() - 1);
                map.put(num, map.get(num) + 1);
            }
        }
    }
}
