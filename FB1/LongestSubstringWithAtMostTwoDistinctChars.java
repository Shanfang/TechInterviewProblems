class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int counter = 0;
        int start = 0, end = 0;
        int maxLen = 1;
        while (end < s.length()) {
            char c1 = s.charAt(end);
            map.put(c1, map.getOrDefault(c1, 0) + 1);
            if (map.get(c1) == 1) {
                counter++;
            }
            end++;

            while (counter > 2) {
                char c2 = s.charAt(start);
                map.put(c2, map.get(c2) - 1);
                if (map.get(c2) == 0) {
                    counter--;
                }
                start++;
            }
            maxLen = Math.max(maxLen, end - start);
        }
        return maxLen;
    }
}
