class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(new StringBuilder(), n, n, result);
        return result;
    }

    private void helper(StringBuilder sb, int leftP, int rightP, List<String> result) {
        if(leftP == 0 && rightP == 0) {
            result.add(sb.toString());
            return;
        }
        if (leftP > 0) {
            sb.append("(");
            helper(sb, leftP - 1, rightP, result);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (leftP < rightP) {
            sb.append(")");
            helper(sb, leftP, rightP - 1, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
