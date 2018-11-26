class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        helper(candidates, 0, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void helper(int[] candidates, int cur, int sum, int target, List<Integer> list,
                        List<List<Integer>> result) {
        if (sum > target) {
            return;
        }
        
        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = cur; i < candidates.length; i++) {
            list.add(candidates[i]);
            helper(candidates, i, sum + candidates[i], target, list, result);
            list.remove(list.size() - 1);
        }
    }
}
