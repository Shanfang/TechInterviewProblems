// faster recursion, check before move to next recursion
// stringbuilder is faster than pure string concatenation
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        helper(n - 1, n, new StringBuilder("("), result);
        return result;
    }

    private void helper(int leftP, int rightP, StringBuilder sb, List<String> result) {
        if (leftP == 0 && rightP == 0) {
            result.add(sb.toString());
        }
        if (leftP > 0) {
            sb.append("(");
            helper(leftP - 1, rightP, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (leftP < rightP) {
            sb.append(")");
            helper(leftP, rightP - 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

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
