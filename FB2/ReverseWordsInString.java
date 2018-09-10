// in 3 steps
//1. reverse the whole string
//2. reverse each word. A smart way to find start and end index of each word is using two pointers.
// find the start index by moving the startPoitner forward in two cases:
// 2.1 startPointer is behind old endPointer
// 2.2 startPointer is pointing to whitesapce, we need to skip these spaces
// the same idea for finding end index of each word.
// 2.3 endPointer is behind the current startPointer, eg. ___abc, we need to walk until we reach the one behind 'c'
// 2.4 endPoitner is pointing to non-whitespace, we need to skip these and find the next firt whitespace
//3. clean up whitespaces
public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        int len = chars.length;
        reverse(chars, 0, len - 1);

        reverseWords(chars, len);

        return cleanWhitespace(chars, len);
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    private void reverseWords(char[] chars, int len) {
        int start = 0, end = 0;
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

    private String cleanWhitespace(char[] chars, int len) {
        int start = 0, end = 0;
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
        return new String(chars).substring(0 , start);
    }
}
