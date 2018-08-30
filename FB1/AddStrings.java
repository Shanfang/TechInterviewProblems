class Solution {
    public String addStrings(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
            return "";
        }

        int len1 = num1.length();
        int len2 = num2.length();
        if (len1 > len2) {
            return addStrings(num2, num1);
        }

        int carry  = 0, sum = 0;
        StringBuilder sb = new StringBuilder();
        while (len1 > 0) {
            sum = carry + num1.charAt(len1 - 1) - '0' + num2.charAt(len2 - 1) - '0';
            carry = sum / 10;
            sb.append(sum % 10);
            len1--;
            len2--;
        }
        while (len2 > 0) {
            sum = carry + num2.charAt(len2 - 1) - '0';
            carry = sum / 10;
            sb.append(sum % 10);
            len2--;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
