class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];

        helper(nums, new ArrayList<>(), used, result);
        return result;
    }

    private void helper(int[] nums, List<Integer> list, boolean[] used, List<List<Integer>> result) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1] && used[i - 1] || used[i]) {
                continue;
            }
            used[i] = true;
            list.add(nums[i]);
            helper(nums,list, used, result);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}


// not very efficient
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
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
            if (i != 0 && nums[i] == nums[ i - 1] || map.get(nums[i]) == 0) {
                continue;
            }
            map.put(nums[i], map.get(nums[i]) - 1);
            list.add(nums[i]);
            helper(nums,list, map, result);
            list.remove(list.size() - 1);
            map.put(nums[i], map.get(nums[i]) + 1);
        }
    }
}
