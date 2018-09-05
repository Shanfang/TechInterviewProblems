class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }

        helper(n - 1, n, "(", result);
        return result;
    }
    private void helper(int leftP, int rightP, String str, List<String> result) {
        if (leftP > rightP || leftP < 0 || rightP < 0) {
            return;
        }
        if (leftP == 0 && rightP == 0) {
            result.add(str);
        }

        helper(leftP - 1, rightP, str + "(", result);
        helper(leftP, rightP - 1, str + ")", result);
    }
}
