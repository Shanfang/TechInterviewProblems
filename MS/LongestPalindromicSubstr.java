class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int len = s.length();
        int start = 0;
        int maxLen = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = len -1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j) && ((i + 1 > j - 1) || dp[i + 1][j - 1])) {
                    if (j - i + 1 > maxLen) {
                        start = i;
                        maxLen = j - i + 1;
                    }
                    dp[i][j] = true;
                }
            }
        }

        return s.substring(start, start + maxLen);
    }
}
