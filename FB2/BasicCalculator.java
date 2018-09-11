// more intuitive version
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
                stack.push(stack.pop()+ sign * num); // each intermediate result is pushed onto stack
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

// we calculate the intermediate result within each (). This is similar to decode strings.
// When we get a (, use stack to store temp result and sign for the result after (,
// then proceed to get numbers
// until we get a ), pop stack and calculate intermediate result. This result is the expression
// NOT ONLY from the left corresponding (, but until the previous ( before the matched (.
// (1 - (2 + 3)) - 4. When we pop second ), we calculate the result of 1 - (2 + 3)!!

class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int sign = 1;
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(s.charAt(i))) {
                int num  = s.charAt(i) - '0';
                while (i < s.length() - 1 && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                // intermediate result is stored in variable result, result is not pushed onto stack until
                //after evaluated the expression within ()
                result += num * sign;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result = result * stack.pop() + stack.pop();
            }
        }
        return result;
    }
}
