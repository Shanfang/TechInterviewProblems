class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) {
            return -1;
        }
        s = s.replace(" ", "");
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        int i = 0;
        while(i < s.length()) {
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
                i++;
            }
            if (sign == '+') {
                stack.push(num);
            } else if (sign == '-') {
                stack.push(-num);
            } else if (sign == '*') {
                stack.push(stack.pop() * num);
            } else {
                stack.push(stack.pop() / num);
            }
            if (i < s.length()) {
                sign = s.charAt(i++);
                num = 0;
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}


/*
// the following solution is wrong, we can't do addition and subtraction by poping stack
// 1-1+1 would be calculated as-1 = (1-(1+1))
// can be fixed by popping out the numbers and push onto another stack so the order is reversed,
// then do the calculation, but this is too complicated than needed
class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        s = s.replace(" ", "");
        Stack<String> stack = new Stack<>();
        int i = 0;
        int result = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                stack.push(String.valueOf(num));
            } else if (c == '+' || c == '-') {
                stack.push(String.valueOf(c));
                i++;
            } else if (c == '*') {
                i++;
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                int product = num * Integer.parseInt(stack.pop());
                stack.push(String.valueOf(product));
            } else {
                i++;
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                int div = Integer.parseInt(stack.pop()) / num;
                stack.push(String.valueOf(div));
            }
        }

        while (!stack.isEmpty()) {
            int num1 = Integer.parseInt(stack.pop());
                        System.out.println("num1 " + num1);

            if (stack.isEmpty()) {
                result = num1;
                break;
            }
            String operator = stack.pop();
            int num2 = Integer.parseInt(stack.pop());
            System.out.println("num2 " + num2);
            if (operator.equals("-")) {
                stack.push(String.valueOf(num2 - num1));
            } else {
                stack.push(String.valueOf(num1 + num2));
            }
        }
        return result;
    }
}
*/
