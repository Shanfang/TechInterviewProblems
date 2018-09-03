// use template from leetcode
// https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92007/Sliding-Window-algorithm-template-to-solve-all-the-Leetcode-substring-search-problem.
class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int start = 0, end = 0;
        int head = 0;
        int counter = map.size();
        int minLen = Integer.MAX_VALUE;
        while (end < s.length()) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    counter--;
                }
            }
            end++;

            while (counter == 0) {
                char c1 = s.charAt(start);
                if (map.containsKey(c1)) {
                    map.put(c1, map.get(c1) + 1);
                    if (map.get(c1) > 0) {
                        counter++;
                    }
                }
                if (end - start < minLen) {
                    minLen = end -start;
                    head = start;
                }
                start++;
            }
        }
        if (minLen == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(head, head + minLen);
    }
}

class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }
        String result  = "";
        int[] sArray = new int[256];
        int[] tArray = new int[256];
        for (char c : t.toCharArray()) {
            tArray[c]++;
        }

        int left = findNext(s, tArray, 0);
        if (left == s.length()) {
            return result;
        }

        int right = left;
        int tLen = t.length();
        int found = 0;
        while (right < s.length()) {
            int rCharInt = (int)s.charAt(right);
            if (sArray[rCharInt] < tArray[rCharInt]) {
                found++;
            }
            sArray[rCharInt]++;

            // shrink substring by moving left rightward
            while (left < s.length() && found == tLen) {
                if (result.isEmpty() || result.length() > right - left + 1) {
                    result = s.substring(left, right + 1);
                }
                int lCharInt = (int)s.charAt(left);
                if (sArray[lCharInt] <= tArray[lCharInt]) {
                    found--;
                }
                sArray[lCharInt]--;

                left = findNext(s, tArray, left + 1);
            }
            right = findNext(s, tArray, right + 1);
        }

        return result;
    }

    private int findNext(String s, int[] array, int start) {
        while (start < s.length()) {
            if (array[(int)s.charAt(start)] > 0) {
                return start;
            }
            start++;
        }
        return s.length();
    }
}
