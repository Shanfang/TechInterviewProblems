class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        long MOD = 1000000007;
        char[] chars = s.toCharArray();
        long[] dp = new long[s.length() + 1];
        dp[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            dp[i] = dp[i - 1] * count1(chars[i - 1]);

            if (i > 1) {
                dp[i] += dp[i - 2] * count2(chars[i - 2], chars[i - 1]);
            }
            dp[i] %= MOD;
        }
        return (int) dp[s.length()];
    }

    private int count1(char c) {
        if (c == '0') {
            return 0;
        }
        if (c == '*') {
            return 9;
        }
        return 1;
    }

    private int count2(char c1, char c2) {
        if (c1 == '0') {
            return 0;
        }
        if (c1 == '1') {
            if (c2 == '*') {
                return 9;
            }
            return 1;
        }
        if (c1 == '2') {
            if (c2 == '*') {
                return 6;
            }
            if (c2 <= '6') {
                return 1;
            }
            return 0;
        }
        if (c1 >= '3' && c1 <= '9') {
            return 0;
        }

        // the following cases are c1 == '*'
        if (c2 >= '0' && c2 <= '6') {
            return 2; //*c2
        }
        if (c2 >= '7' && c2 <= '9') {
            return 1;
        }
        return 15; //case of **
    }
}
