class Solution {
    public String reverseString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int i = 0, j = s.length() - 1;
        char[] chars = s.toCharArray();
        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return new String(chars);
    }
}
