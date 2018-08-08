class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        Stack<Integer> countStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        int index = 0;
        while (index < s.length()) {
            if (Character.isDigit(s.charAt(index))) {
                int count = 0;
                while (Character.isDigit(s.charAt(index))) {
                    count = count * 10 + (s.charAt(index) - '0');
                    index++;
                } // index now is at [
                countStack.push(count);
            } else {
                if (s.charAt(index) == ']') {
                    StringBuilder sb = new StringBuilder();
                    while (!strStack.peek().equals("[")) {
                        sb.insert(0, strStack.pop());
                    }
                    strStack.pop();// pop out the [
                    String str = sb.toString();
                    int repeat = countStack.pop();
                    while (repeat > 1) {
                        sb.append(str);
                        repeat--;
                    }
                    strStack.push(sb.toString());
                    index++;
                } else {
                    strStack.push(String.valueOf(s.charAt(index)));
                    index++;
                }
            }
        }
        StringBuilder strBuilder = new StringBuilder();
        while (!strStack.isEmpty()) {
            strBuilder.insert(0, strStack.pop());
        }
        return strBuilder.toString();
    }
}
