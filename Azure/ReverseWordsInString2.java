class Solution {
    public void reverseWords(char[] str) {
        if (str == null || str.length == 0) {
            return;
        }

        reverse(str, 0, str.length - 1);
        int start = 0, end = 0;
        while (end < str.length) {
            if (str[end] == ' ') {
                reverse(str, start, end - 1);
                start = end + 1;
            }
            end++;
        }
        reverse(str, start, str.length - 1);
    }

    private void reverse(char[] chars, int i, int j) {
        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
    }
}
