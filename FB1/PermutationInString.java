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
