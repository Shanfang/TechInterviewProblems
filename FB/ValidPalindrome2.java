class Solution {
    public boolean validPalindrome(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            int j = len -  i - 1;
            if (s.charAt(i) != s.charAt(j)) {
                return subPalindrome(s, i, j - 1) || subPalindrome(s, i + 1, j);
            }
        }
        return true;
    }

    private boolean subPalindrome (String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
