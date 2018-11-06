import java.util.*;
import java.lang.Math;

class BinaryToDecimal {
    static int convert(String binary) {
        char[] chars = binary.toCharArray();
        int len = chars.length;
        int i = len - 1;
        int decimal = 0;
        while (i >= 0) {
            int exp = chars[i] - '0';
            if (exp == 1) {
                decimal += Math.pow(2, len - i - 1);
            }
            i--;
        }
        return decimal;
    }

    public static void main(String[] args) {
        String str = "10101";
        System.out.println(convert(str));
    }
}
