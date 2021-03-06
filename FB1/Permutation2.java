// no need to sort array to handle duplicates
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
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

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        helper(nums, used, new ArrayList<>(), result);
        return result;
    }

    private void helper(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
        }

        // it is not enough to use i != 0 && nums[i] == nums[i - 1] to skip duplicate!!!!
        // In case nums[i - 1] is used in previous recursion, we can use nums[i] even if i! = 0 && nums[i] == nums[i - 1]
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            used[i] = true;
            helper(nums, used, list, result);
            used[i] = false;
            list.remove(list.size() - 1);

        }
    }
}
