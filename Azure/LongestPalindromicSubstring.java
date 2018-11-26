class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int len1 = 1, len2 = 1;
        int maxLen = 1;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            len1 = expand(s, i, i);
            len2 = expand(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > maxLen) {
                maxLen = len;
                start = i - (len + 1) / 2 + 1;
            }
        }
        return s.substring(start, start + maxLen);
    }
    private int expand(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }
}
