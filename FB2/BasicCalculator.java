class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(s.charAt(i))) {
                int num  = s.charAt(i) - '0';
                while (i < s.length() - 1 && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                stack.push(stack.pop()+ sign * num);
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '(') {
                stack.push(sign);
                stack.push(0);
                sign = 1;
            } else if (c == ')') {
                stack.push(stack.pop() * stack.pop() + stack.pop());
            }
        }
        return stack.pop();
    }
}
