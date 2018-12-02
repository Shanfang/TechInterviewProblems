import java.util.*;

class BasicCalculator0 {
    // static int calculate(String str) {
    //     if (str == null || str.length() == 0) {
    //         return 0;
    //     }
    //     Stack<Integer> stack = new Stack<>();
    //     int num = 0;
    //     char sign = '+';
    //     for (int i = 0; i < str.length(); i++) {
    //         char c = str.charAt(i);
    //         if (c == ' ') {
    //             continue;
    //         }
    //         if (Character.isDigit(c)) {
    //              num = num * 10 + c - '0';
    //         }
    //         if (!Character.isDigit(c) || i == str.length() - 1) {
    //             if (sign == '+') {
    //                 stack.push(num);
    //             } else if (sign == '-') {
    //                 stack.push(-num);
    //             } else if (sign == '*') {
    //                 stack.push(stack.pop() * num);
    //             } else if (sign == '/') {
    //                 stack.push(stack.pop() / num);
    //             }
    //             sign = c;
    //             num = 0;
    //         }
    //     }
    //     int result = 0;
    //     while (!stack.isEmpty()) {
    //         result += stack.pop();
    //     }
    //     return result;
    // }

    // with two stack
    static int calculate (String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        Stack<Character> opeStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else {
                numStack.push(num);
                if (!opeStack.isEmpty() && checkPrecedence(c, opeStack.peek())) { // c < opeStack.top()
                    numStack.push(cal(numStack.pop(), numStack.pop(), opeStack.pop()));
                }
                opeStack.push(c);
                num = 0;
            }
        }
        numStack.push(num);
        while (!opeStack.isEmpty()) {
            numStack.push(cal(numStack.pop(), numStack.pop(), opeStack.pop()));
        }
        return numStack.pop();
    }

    private static boolean checkPrecedence(char c1, char c2) {
        return (c1 == '+' || c1 == '-') && (c2 == '*' || c2 == '/');
    }

    private static int cal(int num1, int num2, char ope) {
        if (ope == '+') {
            return num1 + num2;
        } else if (ope == '-') {
            return num2 - num1;
        } else if (ope == '*') {
            return num1 * num2;
        } else {
            return num2 / num1;
        }
    }
    public static void main(String[] args) {
        String str = "1 + 12 * 3 - 12 / 3"; //33
        System.out.println(calculate(str));
    }
}
