class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= s.length(); i++) {
            int digit = s.charAt(i - 1) - '0';
            int digits = (s.charAt(i - 2) - '0') * 10 + digit;
            if (digit > 0 && digit <= 9) {
                dp[i] = dp[i - 1];
            }
            if (digits >= 10 && digits <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}


// constant space complexity
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int nums[] = new int[3];
        nums[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            nums[i % 3] = 0;
            if (s.charAt(i - 1) != '0'){
                nums[i % 3] = nums[(i - 1) % 3];
            }
            if (i > 1) {
                int digits = Integer.parseInt(s.substring(i - 2, i));
                if (digits >= 10 && digits <= 26) {
                    nums[i % 3] += nums[(i - 2) % 3];
                }
            }
        }
        return nums[s.length() % 3];
    }
}
