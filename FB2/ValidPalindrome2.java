// note:
// 1. don't take substring, just pass in the starting and ending indexes for substring to helper method
// 2. NEVER forget to change indexes in while loop!!!
class Solution {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isPalindrome(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
