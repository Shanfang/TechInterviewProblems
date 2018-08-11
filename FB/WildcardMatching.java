class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return s == p;
        }

        int lenS = s.length();
        int lenP = p.length();
        boolean[][] dp = new boolean[lenS + 1][lenP + 1];
        dp[0][0] = true;
        for (int i = 0; i <= lenS; i++) {
            for (int j = 0; j <=lenP; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = false;
                    continue;
                }
                if (p.charAt(j - 1) != '*') {
                    if (i > 0 && (p.charAt(j - 1)== '?' || p.charAt(j - 1) == s.charAt(i - 1))) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else {
                    dp[i][j]= dp[i][j - 1];
                    if (i > 0) {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                    }
                }
            }
        }
        return dp[lenS][lenP];
    }
}
