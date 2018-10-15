// longest substring without repeating chars
import java.util.*;

class LongestSubstring {
    static String longest(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        int maxLen = 1;
        int start = 0, left = 0, end = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (end < str.length()) {
            char c = str.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c) + 1);
            }
            if (end - start + 1 > maxLen) {
                maxLen = end - start + 1;
                left = start;
            }
            map.put(c, end);
            end++;
        }
        System.out.println("Max length is " + maxLen);
        return str.substring(left, left + maxLen);
    }
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        String str = input.nextLine().trim();
        System.out.println(longest(str));
    }
}