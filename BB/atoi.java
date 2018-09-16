class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        if (str == null || str.length() == 0) {
            return 0;
        }
        int index = 0;
        int num = 0;
        int sign = 1;
        char c = str.charAt(index);
        if (c == '+' || c == '-') {
            sign = c == '-' ? -1 : 1;
            index++;
        }

        while (index < str.length() && Character.isDigit(str.charAt(index))) {
            char c2 = str.charAt(index);
            if (num > Integer.MAX_VALUE / 10 || num == Integer.MAX_VALUE / 10 && c2 - '0' > Integer.MAX_VALUE % 10) {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            num = num * 10 + c2 - '0';
            index++;
        }
        return sign * num;
    }
}
