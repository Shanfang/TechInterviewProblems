class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                numStack.push(num);
            } else{
                if (s.charAt(i) == ']') {
                    i++;
                    int repeat = numStack.pop();
                    StringBuilder sb = new StringBuilder();
                    while (!strStack.peek().equals("[")) {
                        sb.insert(0, strStack.pop());
                    }
                    strStack.pop();
                    String str = sb.toString();
                    String temp = str;
                    while (repeat > 1) {
                        str += temp;
                        repeat--;
                    }
                    strStack.push(str);
                } else {
                    strStack.push(String.valueOf(s.charAt(i)));
                    i++;
                }
            }
        }
        StringBuilder sb1 = new StringBuilder();
        while (!strStack.isEmpty()) {
            sb1.insert(0, strStack.pop());
        }
        return sb1.toString();
    }
}
