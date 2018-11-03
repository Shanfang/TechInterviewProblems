import java.util.*;

class SortXY {
    static String sortXY(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }
        char[] chars = input.toCharArray();
        int i = 0, j = 0;
        while (i < input.length()) {
            if (chars[i] == 'Y') {
                char temp = chars[j];
                chars[j] = chars[i];
                chars[i] = temp;
                j++;
            }
            i++;
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        String input = "YXYYXXXYX";
        System.out.println(sortXY(input));
    }
}
