import java.util.*;

class StringComparator {
    public static int compare(String str1, String str2) {
        int i = 0, j = 0;
        int num1 = 0, num2 = 0;
        while (i < str1.length() && j < str2.length()) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(j);
            if (Character.isDigit(c1) && Character.isDigit(c2)) {
                while (i < str1.length() && Character.isDigit(str1.charAt(i))) {
                    num1 = num1 * 10 + str1.charAt(i) - '0';
                    i++;
                }
                while (j < str2.length() && Character.isDigit(str2.charAt(j))) {
                    num2 = num2 * 10 + str2.charAt(j) - '0';
                    j++;
                }
                if (num1 == num2) {
                    continue;
                }
                return num1 - num2 < 0 ? -1 : 1;
            } else {
                if (c1 == c2) {
                    i++;
                    j++;
                    continue;
                } else if (c1 == '.' || c2 == '.') {
                    return c1 == '.' ? -1 : 1;
                }
                return c1 - c2 < 0 ? -1 : 1;
            }
        }
        // if (i == str1.length() && j == str2.length()) {
        //     return 0;
        // } else {
        //     return i == str1.length() ? -1 : 1;
        // }
        return 0;
    }

    public static void main(String[] args) {
        String s1 = "appl1.txt";
        String s2 = "apple.txt";
        System.out.println(compare(s1, s2));
    }
}
