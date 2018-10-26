class Solution {
    public String solveEquation(String equation) {
        if (equation == null || equation.length() == 0) {
            return "Infinite solutions";
        }

        Stack<Integer> xStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        String[] strs = equation.split("=");
        int i = 0;
        String str1 = strs[0];
        String str2 = strs[1];

    }

    private void eval(Stack<Integer> xStack, Stack<Integer> numStack, String str1) {
        int count = 0;
        int sign = 1;
        while (i < str1.length()) {
            char c = str1.charAt(i);
            if(Character.isDigit(c)) {
                while(i < str1.length() && Character.isDigit(str1.charAt(i))) {
                    count = count * 10 + str1.charAt(i) - '0';
                    i++;
                }
                if (i < str1.length() && str1.charAt(i) == 'x') {
                    xStack.push(count);
                } else {
                    numStack.push(sign * count);
                }
                count = 0;
            } else if(c == 'x') {
                xStack.push(1);
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            }
            i++;
        }
    }
}
