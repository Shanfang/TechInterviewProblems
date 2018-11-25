class Solution {
    public String reverseStr(String s, int k) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int i = 0;
        char[] chars = s.toCharArray();
        while (i < s.length()) {
            int end = Math.min(i + k - 1, s.length() - 1);
            swap(chars, i, end);
            i += 2 * k;
        }
        return String.valueOf(chars);
    }

    private void swap(char[] chars, int i, int j) {
        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
    }
}
