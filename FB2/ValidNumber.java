// dot is more strict than e. Two scenarioes are not allowed:
// 1. two dots are not allowed
// 2. e is not allowed before.
// thus, when we see a dot, we need to check the following cases

// e is slightly less strict. We only need to check if there are more than one E in the string

// for the sign +/-, it is allowd to appear in either the head of expression, or right after E.

// when we get a digit. We mark it as either preNum or postNum(relative to E).

// In the end, we check if there is E in the expression, then both preNum and postNum should be there.
// Otherwise, preNum should be there.
class Solution {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0){
            return true;
        }
        boolean preNum = false;
        boolean postNum = false;
        boolean seenE = false;
        boolean seenDot = false;
        s = s.trim().toLowerCase();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                if (seenE) {
                    postNum = true;
                } else {
                    preNum = true;
                }
            } else if (c == '.') {
                if (seenE || seenDot) {
                    return false;
                }
                seenDot = true;
            } else if (c == 'e') {
                if (seenE) {
                    return false;
                }
                seenE = true;
            } else if (c == '+' || c == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
            i++;
        }
        return seenE ? preNum && postNum : preNum;
    }
}
