class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }

        Arrays.sort(candidates);
        helper(candidates, target, 0, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private void helper(int[] candidates, int target, int sum, int index, List<Integer> list,
                                        List<List<Integer>> result) {
        if (sum > target || index == candidates.length) {
            return;
        }

        if (sum == target) {
            result.add(new ArrayList<>(list));
        }

        for (int i = index; i < candidates.length; i++) {
            if (i != 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            helper(candidates, target, sum + candidates[i], i, list, result);
            list.remove(list.size() - 1);
        }
    }
}
