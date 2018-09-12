class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int counter = map.size();
        int start = 0, end = 0;
        int i = 0;
        int minLen = Integer.MAX_VALUE;
        while (end < s.length()) {
            char c1 = s.charAt(end);
            if (map.containsKey(c1)) {
                map.put(c1, map.get(c1) - 1);
                if (map.get(c1) == 0) {
                    counter--;
                }
            }
            end++;

            while (counter == 0) {
                if (end - start < minLen) {
                    minLen = end - start;
                    i = start;
                }
                char c2 = s.charAt(start);
                if (map.containsKey(c2)) {
                    map.put(c2, map.get(c2) + 1);
                    if (map.get(c2) > 0) {
                        counter++;
                    }
                }
                start++;
            }
        }
        if (minLen == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(i, i + minLen);
    }
}
