class Solution {
    public String reverseStr(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        int i = 0;
        while (i < s.length()) {
            int j = Math.min(i + k - 1, s.length() - 1);
            swap(chars, i, j);
            i += 2 * k;
        }
        return new String(chars);
    }

    private void swap(char[] chars, int i, int j) {
        while (i < j) {
            char temp = chars[i];
            chars[i++] = chars[j];
            chars[j--] = temp;
        }
    }
}
