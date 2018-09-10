class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int num1 = i >= 0 ? a.charAt(i) - '0' : 0;
            int num2 = j >= 0 ? b.charAt(j) - '0' : 0;
            int sum =  num1 + num2 + carry;
            sb.append(sum % 2);
            carry = sum / 2;
            i--;
            j--;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
