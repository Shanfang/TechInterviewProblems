class Solution {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        s = s.toLowerCase().trim();
        boolean preENum = false;
        boolean postENum = false;
        boolean dotSeen = false;
        boolean eSeen = false;
        for (int i = 0;i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                if (!eSeen) {
                    preENum = true;
                }
                if (eSeen) {
                    postENum = true;
                }
            } else if (c == '-' || c == '+') {
                if (i != 0 && s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else if (c == '.') {
                if (dotSeen || eSeen) {
                    return false;
                }
                dotSeen = true;
            } else if (c == 'e') {
                if (eSeen) {
                    return false;
                }
                eSeen = true;
            } else {
                return false;
            }
        }
        return eSeen ? preENum && postENum : preENum;
    }
}
