class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int leftIdx = -1;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    leftIdx = i;
                } else {
                    stack.pop();
                    if (!stack.isEmpty()) {
                        maxLen = Math.max(maxLen, i - stack.peek());    
                    } else {
                        maxLen = Math.max(maxLen, i - leftIdx);
                    }
                }
            }
        }
        return maxLen;
    }
}
