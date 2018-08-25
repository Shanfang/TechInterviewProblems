class Solution {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }

        for (int i = 0; i < s.length(); i++) {
            int j = s.length() - 1 - i;
            if (s.charAt(i) != s.charAt(j)) {
                return checkSubstring(s, i + 1, j) || checkSubstring(s, i, j - 1);
            }
        }
        return true;
    }

    private boolean checkSubstring(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
