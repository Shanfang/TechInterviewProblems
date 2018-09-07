class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        dfs(num, target, 0, 0, 0, "", result);
        return result;
    }

    private void dfs(String num, int target, int index, long eval, long multi, String curExp, List<String> result) {
        if(index == num.length()) {
            if (eval == target) {
                 result.add(curExp);
                return;
            }
        }

        for (int i = index; i < num.length(); i++) {
            if (num.charAt(index) == '0' && i != index) {
                break;
            }
            long curVal = Long.parseLong(num.substring(index, i + 1));
            if (index == 0) {
                dfs(num, target, i + 1, curVal, curVal, curExp + curVal, result);
            } else {
                dfs(num, target, i + 1, eval + curVal, curVal, curExp + "+" + curVal, result);
                dfs(num, target, i + 1, eval - curVal, -curVal, curExp + "-" + curVal, result);
                dfs(num, target, i + 1, eval - multi + multi * curVal, multi * curVal, curExp + "*" + curVal, result);
            }

        }
    }
}
