class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null) {
            return result;
        }

        // check number of invalid left and right parentheses
        int leftP = 0, rightP = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftP++;
            }
            if (c == ')') {
                if (leftP > 0) {
                    leftP--;
                } else {
                    rightP++;
                }
            }
        }

        // try to remove each invalid left and right parentheses
        helper(s, 0, leftP, rightP, result);
        return result;
    }

    private void helper(String str, int start, int leftP, int rightP, List<String> result) {
        if (leftP == 0 &&  rightP == 0) {
            if (isValid(str)) {
                result.add(str);
            }
            return;
        }

        for (int i = start; i < str.length(); i++) {
            if (str. charAt(i) != '(' && str.charAt(i) != ')') {
                continue;
            }

            if (i > start && str.charAt(i) == str.charAt(i - 1)) {
                continue;
            }
            String newStr = str.substring(0, i) + str.substring(i + 1);
            // if (str.charAt(i) == '(') {
            //     helper(newStr, i, leftP - 1, rightP, result);
            // } else {
            //   helper(newStr, i, leftP, rightP - 1, result);
            // }
            if (rightP > 0) {
                helper(newStr, i, leftP, rightP - 1, result);
            } else if (leftP > 0) {
              helper(newStr, i, leftP - 1, rightP, result);
            }
        }
    }

    private boolean isValid(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == '(') {
                count++;
            }
            if (c == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }
}
