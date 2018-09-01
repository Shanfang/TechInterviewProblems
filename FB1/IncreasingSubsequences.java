class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0)  {
            return result;
        }

        helper(nums, 0, new LinkedList<>(), result);
        return result;
    }

    private void helper(int[] nums, int start, LinkedList<Integer> list, List<List<Integer>> result) {
        if (list.size() >= 2) {
            result.add(new ArrayList<>(list));
        }
        if (start == nums.length) {
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            if (list.size() == 0 || list.peekLast() <= nums[i]) {
                set.add(nums[i]);
                list.add(nums[i]);
                helper(nums, i + 1, list, result);
                list.removeLast();
            }
        }
    }
}
