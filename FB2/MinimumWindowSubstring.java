class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, start = 0;
        int minLen = Integer.MAX_VALUE;
        int counter = map.size();
        while (right < s.length()) {
            char c1 = s.charAt(right);
            if (map.containsKey(c1)) {
                map.put(c1, map.get(c1) - 1);
                if (map.get(c1) == 0) {
                    counter--;
                }
            }
            right++;

            while (counter == 0) {
                char c2 = s.charAt(left);
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }
                if (map.containsKey(c2)) {
                    map.put(c2, map.get(c2) + 1);
                    if (map.get(c2) > 0) {
                        counter++;
                    }
                }
                left++;
            }
        }
        if (minLen == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(start, start + minLen);
    }
}
