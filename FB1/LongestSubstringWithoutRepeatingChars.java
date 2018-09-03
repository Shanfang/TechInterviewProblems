// two pointers
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int start = -1, end = 0;
        int maxLen = 1;

        while (end < s.length()) {
            char c1 = s.charAt(end);
            if (map.containsKey(c1)) {
                start = Math.max(start, map.get(c1));
            }
            maxLen = Math.max(maxLen, end - start);
            map.put(c1, end);
            end++;
        }
        return maxLen;
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int start = -1;
        int maxLen = 1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c));
            }
            map.put(c, i);
            maxLen = Math.max(maxLen, i - start);
        }
        return maxLen;
    }
}
