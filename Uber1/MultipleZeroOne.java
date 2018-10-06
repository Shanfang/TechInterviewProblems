import java.math.BigInteger;
// use BigInteger to hold very large numbers, treat it as a class
class MultipleZeroOne {
    static BigInteger findMultiple (int num) {
        int i = 1;
        BigInteger result = BigInteger.valueOf(0);
        BigInteger base = BigInteger.valueOf(num);
        while (true) {
            BigInteger multiple = base.multiply(BigInteger.valueOf(i));
            String str = String.valueOf(multiple);
            int j = 0;
            for (; j < str.length(); j++) {
                if (str.charAt(j) != '0' && str.charAt(j) != '1') {
                    break;
                }
            }
            if (j == str.length()) {
                result = multiple;
                break;
            }
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findMultiple(317));
    }
}
