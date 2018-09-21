public void reverseString(String str) {
    if (str == null || str.length() == 0){
        return;
    }
    int start = 0, end = 0;
    int len = str.length();
    char[] chars = str.toCharArray();
    
    while (start < len) {
        while (start < len && chars[start] == ' ' || start < end) {
            start++;
        }
        while (end < len && chars[end] != ' ' || end < start) {
            end++;
        }
        reverse(chars, start, end - 1);
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char c = chars[start];
            chars[start] = chars[end];
            chars[end] = c;
            start++;
            end--;
        }
    }
}
