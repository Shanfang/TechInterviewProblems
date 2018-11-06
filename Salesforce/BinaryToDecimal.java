import java.util.*;
import java.lang.Math;

class BinaryToDecimal {
    // for string input that is in 2's complete
    static int convert(String input) {
        char[] chars = input.toCharArray();
        int sign = 1;
        if (chars[0] == '1') {
            sign = -1;
            System.out.println("Before flipping " + String.valueOf(chars));
            flipAndAddOne(chars);
            System.out.println("After flipping " + String.valueOf(chars));

        }
        int result = helper(chars);
        return result * sign;
    }
    static int helper(char[] chars) {
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
    static void flipAndAddOne(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') {
                chars[i] = '0';
            } else {
                chars[i] = '1';
            }
        }
        int carry = 1;
        for (int i = chars.length - 1; i >= 0; i--) {
            int digit = chars[i] - '0';
            if (digit + carry == 2) {
                chars[i] = '0';
                carry = 1;
            } else if (digit + carry == 1) {
                chars[i] = '1';
                carry = 0;
            } else {
                chars[i] = '0';
                carry = 0;
            }
        }
    }
    // for integer input
    // static int convert(int input) {
    //     int decimal = 0;
    //     int i = 0;
    //     while (input != 0) {
    //         int digit = input % 2;
    //         if (digit == 1) {
    //             decimal += Math.pow(2, i);
    //         }
    //         i++;
    //         input /= 10;
    //     }
    //     return decimal;
    // }

    // input is in string format
    // static int convert(String binary) {
    //     char[] chars = binary.toCharArray();
    //     int len = chars.length;
    //     int i = len - 1;
    //     int decimal = 0;
    //     while (i >= 0) {
    //         int exp = chars[i] - '0';
    //         if (exp == 1) {
    //             decimal += Math.pow(2, len - i - 1);
    //         }
    //         i--;
    //     }
    //     return decimal;
    // }

    public static void main(String[] args) {
        String str = "10101";
        // int str = 10101;
        System.out.println(convert(str));
    }
}
