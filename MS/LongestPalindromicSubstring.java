// DP with O(N^2) space complexity, N is the length of string
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int len = s.length();
        boolean[][] dp = new boolean [len][len];
        int start = 0;
        int maxLen = 0;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j) && (i + 1 > j - 1 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (maxLen < j - i + 1) {
                        maxLen = j - i + 1;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}

// constant space complexity
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int longest = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            int maxLen = Math.max(len1, len2);
            if (maxLen > longest) {
                start = i - (maxLen - 1) / 2;
                longest = maxLen;
            }
        }
        return s.substring(start, start + longest);
    }

// more concise verseion of expand
    public int expand(String str, int start, int end) {
        while (start >= 0 && end < str.length() && str.charAt(start) == str.charAt(end)) {
            start--;
            end++;
        }
        return end - start - 1;
    }
    // private int expand(String str, int i, int j) {
    //     int len = 0;
    //     while (i >= 0 && j < str.length()) {
    //         if (str.charAt(i) == str.charAt(j)) {
    //             len = i == j ? len + 1 : len + 2;
    //             i--;
    //             j++;
    //         } else {
    //             break;
    //         }
    //     }
    //     return len;
    // }
}
