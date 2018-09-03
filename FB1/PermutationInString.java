// with better time complexity using slide window than the second approach
// time complexiyt is  O(L1 + (L2- L1))
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s1.length() == 0) {
            return true;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int counter = map.size();
        int start = 0, end = 0;
        while (end < s2.length()) {
            char c1 = s2.charAt(end);
            if (map.containsKey(c1)) {
                map.put(c1, map.get(c1) - 1);
                if (map.get(c1) == 0) {
                    counter--;
                }
            }
            end++;

            while (counter == 0) {
                if (end - start == s1.length()) {
                    return true;
                }
                char c2 = s2.charAt(start);
                if (map.containsKey(c2)) {
                    map.put(c2, map.get(c2) + 1);
                    if (map.get(c2) > 0) {
                        counter++;
                    }
                }
                start++;
            }
        }
        return false;
    }
}


// this approach check the count map every we slide the window by one character
// time complexity is O(L1 + 26 * (L2- L1))
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s1.length() == 0) {
            return true;
        }

        int[] count = new int[26];
        for (char c : s1.toCharArray()) {
            count[c - 'a']++;
        }
        int len1 = s1.length();
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            count[c - 'a']--;
            if (i >= s1.length()) {
                count[s2.charAt(i - len1) - 'a']++;
            }
            if (validPermu(count)) {
                return true;
            }
        }
        return false;
    }

    private boolean validPermu(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
