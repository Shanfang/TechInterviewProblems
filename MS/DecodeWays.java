class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();

        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < len; i++) {
            int digit = s.charAt(i) - '0';
            int digits = Integer.valueOf(s.substring(i - 1, i + 1));
            if (digit > 0 && digit <= 9) {
                dp[i + 1] = dp[i];
            }
            if (digits >= 10 && digits <= 26) {
                dp[i + 1] += dp[i - 1];
            }
        }
        return dp[len];
    }
}
