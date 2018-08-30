class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != c) {
                    return false;
            }
        }
        return stack.isEmpty();
    }
}

/*
the following solution is wrong, it does not guarantee that each pair is matched
it can be used to check only one type of parentheses
class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int p1 = 0; // ()
        int p2 = 0;// {}
        int p3 = 0; // []
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                    p1++;
                    break;
                case ')':
                    p1--;
                    if(p1 < 0) {
                        return false;
                    }
                    break;
                case '{':
                    p2++;
                    break;
                case '}':
                    p2--;
                    if (p2 < 0) {
                        return false;
                    }
                    break;
                case '[':
                    p3++;
                    break;
                case ']':
                    p3--;
                    if(p3 < 0) {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }
}
*/
