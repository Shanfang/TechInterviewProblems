import java.util.*;

class BasicCalculator0 {
    static int calculate(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (Character.isDigit(c)) {
                 num = num * 10 + c - '0';
            }
            if (!Character.isDigit(c) || i == str.length() - 1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = c;
                num = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "1 + 12 * 3 - 12 / 3"; //33
        System.out.println(calculate(str));
    }
}
