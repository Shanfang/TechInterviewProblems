class Solution {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        int i = 0, len = s.length();
        while (i < len && Character.isWhitespace(s.charAt(i))) {
            i++;
        }

        if (i < len && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            i++;
        }

        boolean hasDigit = false;
        while (i < len && Character.isDigit(s.charAt(i))) {
            hasDigit = true;
            i++;
        }

        if (i < len && s.charAt(i) == '.') {
            i++;
            while (i < len && Character.isDigit(s.charAt(i))) {
                hasDigit = true;
                i++;
            }
        }

        if (i < len && s.charAt(i) == 'e' && hasDigit) {
            i++;
            hasDigit = false;
            if (i < len && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
                i++;
            }
            while (i < len && Character.isDigit(s.charAt(i))) {
                hasDigit = true;
                i++;
            }
        }

        while (i < len && Character.isWhitespace(s.charAt(i))) {
            i++;
        }
        return hasDigit && i == len;
    }
}
