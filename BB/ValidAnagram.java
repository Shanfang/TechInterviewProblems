class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null) {
            return t == null;
        }

        if (s.length() != t.length()) {
            return false;
        }

        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            chars[c - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            chars[c - 'a']--;
            if (chars[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
