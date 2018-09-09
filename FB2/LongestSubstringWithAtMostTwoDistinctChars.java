class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLen = 1;
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0;
        int count = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) == 1) {
                count++;
            }
            end++;

            while (count > 2) {
                char c1 = s.charAt(start);
                map.put(c1, map.get(c1) - 1);
                if (map.get(c1) == 0) {
                    count--;
                }
                start++;
            }
            maxLen = Math.max(maxLen, end - start);
        }
        return maxLen;
    }
}
