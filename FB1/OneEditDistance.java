class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                return s.substring(i).equals(t.substring(j + 1)) ||
                        s.substring(i + 1).equals(t.substring(j + 1)) ||
                        s.substring(i + 1).equals(t.substring(j));
            }
        }
        return Math.abs(s.length() - t.length()) == 1;
    }
}
