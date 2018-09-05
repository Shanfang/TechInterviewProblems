class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null) {
            return t == null;
        }
        if (s.length() == 0) {
            return t.length() == 0;
        }

        int[] counter = new int[26];
        for (char c : s.toCharArray()) {
            counter[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            counter[c - 'a']--;
            if (counter[c - 'a'] < 0) {
                return false;
            }
        }
        // for (int i = 0; i < 26; i++) {
        //     if (counter[i] != 0) {
        //         return false;
        //     }
        // }
        return true;
    }
}
