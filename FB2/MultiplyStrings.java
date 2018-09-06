class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
            return "";
        }
        int len1 = num1.length();
        int len2 = num2.length();
        int[] digits = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int pre = i + j;
                int post = i + j + 1;
                int sum = digits[post] + product;
                digits[post] = sum % 10;
                digits[pre] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int digit : digits) {
            if (sb.length() != 0 || digit != 0) {
                sb.append(digit);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
