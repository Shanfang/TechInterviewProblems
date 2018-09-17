class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                if (stack.peek() != -1 && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                    maxLen = Math.max(maxLen, i - stack.peek());
                } else {
                    stack.push(i);
                }
            }
        }
        return maxLen;
    }
}
