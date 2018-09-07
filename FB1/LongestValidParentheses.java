// brut force solution O(N^3)
class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int longest = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 2; j <= s.length(); j++) {
                String str = s.substring(i, j);
                if (valid(str)) {
                    longest = Math.max(longest, j - i);
                }
            }
        }
        return longest;
    }

    private boolean valid(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
