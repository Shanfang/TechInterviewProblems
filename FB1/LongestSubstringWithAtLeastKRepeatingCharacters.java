class Solution {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] counter = new int[26];
        for (char c : s.toCharArray()) {
            counter[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++ ) {
            if (counter[s.charAt(i) - 'a'] < k) {
                sb.setCharAt(i, ',');
            }
        }

        String[] strings = sb.toString().split(",");
        if (strings.length == 1) {
            return strings[0].length();
        }
        int maxLen = 0;
        for (String str : strings) {
            maxLen = Math.max(maxLen, longestSubstring(str, k));
        }
        return maxLen;
    }
}
