/*
referenced
https://www.geeksforgeeks.org/expression-evaluation/
*/
class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Stack<Integer> numStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (Character.isDigit(c)) {
                num = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                numStack.push(num);
                num = 0;
            } else if (c == '(') {
                opStack.push(c);
            } else if (c == ')') {
                while (opStack.peek() != '(') {
                    numStack.push(calculate(opStack.pop(), numStack.pop(), numStack.pop()));
                }
                opStack.pop(); // pop off '('
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!opStack.isEmpty() && noHigherPrecedence(c, opStack.peek())) {
                    numStack.push(calculate(opStack.pop(), numStack.pop(), numStack.pop()));
                }
                opStack.push(c);
            }
        }

        while (!opStack.isEmpty()) {
            numStack.push(calculate(opStack.pop(), numStack.pop(), numStack.pop()));
        }
        return numStack.pop();
    }

    private boolean noHigherPrecedence(Character c1, Character c2) {
        if ((c2 == '+' || c2 == '-') && (c1 == '*' || c1 == '/')) {
            return false;
        }
        if (c2 == '(' || c2 == ')') {
            return false;
        }
        return true;
    }

    private int calculate(Character op, int num1, int num2) {
        switch (op) {
            case '+' : return num2 + num1;
            case '-' : return num2 - num1;
            case '*' : return num2 * num1;
            case '/' : return num2 / num1;
        }
        return 0;
    }
}
