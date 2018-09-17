public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] chars = s.toCharArray();
        int len = s.length();
        reverse(chars, 0, len - 1);
        reverseWord(chars);
        return removeWhitespace(chars);
    }

    private void reverse(char[] chars, int i, int j) {
        while (i  < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
    }

    private void reverseWord(char[] chars) {
        int start = 0, end = 0;
        int len = chars.length;
        while (start < len) {
            while (start < end || (start < len && chars[start] == ' ')) {
                start++;
            }
            while (end < start || (end < len && chars[end] != ' ')) {
                end++;
            }
            reverse(chars, start, end - 1);
        }
    }

    private String removeWhitespace(char[] chars) {
        int start = 0, end = 0;
        int len = chars.length;
        while (end < len) {
            while (end < len && chars[end] == ' ') {
                end++;
            }
            while (end < len && chars[end] != ' ') {
                chars[start++] = chars[end++];
            }
            while (end < len && chars[end] == ' ') {
                end++;
            }
            if (end < len) {
                chars[start++] = ' ';
            }
        }
        return String.valueOf(chars).substring(0, start);
    }
}
