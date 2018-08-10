class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return result;
        }
        dfs(num, target, 0, 0, 0, "", result);
        return result;
    }

    private void dfs(String num, int target, int index, long evaluation, long multiplicand,
                    String subExp, List<String> result) {
        if (index == num.length()) {
            if (evaluation == target) {
                result.add(subExp);
                return;
            }
        }

        for (int i = index; i < num.length(); i++) {
            if (num.charAt(index) == '0' && i != index) { // which means 01 is not allowed
                break;
            }
            long curVal = Long.parseLong(num.substring(index, i + 1));
            if (index == 0) {
                dfs(num, target, i + 1, curVal, curVal, subExp + curVal, result);
            } else {
                dfs(num, target, i + 1, evaluation + curVal, curVal, subExp + "+" + curVal, result);
                dfs(num, target, i + 1, evaluation - curVal, -curVal, subExp + "-" + curVal, result);
                dfs(num, target, i + 1, evaluation - multiplicand + multiplicand * curVal, multiplicand * curVal, subExp + "*" + curVal, result);
            }
        }
    }
}
