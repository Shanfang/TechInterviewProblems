class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        helper(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void helper(int[] array, int start, List<Integer> list, List<List<Integer>> result) {
        result.add(new ArrayList<>(list));

        for (int i = start; i < array.length; i++) {
            list.add(array[i]);
            helper(array, i + 1, list, result);
            list.remove(list.size() - 1);
        }
    }
}
