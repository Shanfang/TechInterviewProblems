class Solution {
    public String addBinary(String a, String b) {
        if (a == null || b == null) {
            return null;
        }
        if (a.length() == 0) {
            return b;
        }
        if (b.length() == 0) {
            return a;
        }
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int digit1 = 0, digit2 = 0, sum = 0;
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0) {
            digit1 = i >= 0 ? a.charAt(i) - '0' : 0;
            digit2 = j >= 0 ? b.charAt(j) - '0' : 0;
            sum = digit1 + digit2 + carry;
            carry = sum / 2;
            sb.append(sum % 2);
            i--;
            j--;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
