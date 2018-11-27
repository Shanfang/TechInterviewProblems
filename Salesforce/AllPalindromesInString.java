import java.util.*;

class AllPalindromesInString {
    static List<String> allPalindromes(String str) {
        List<String> result = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return result;
        }

        for (int i = 0; i < str.length(); i++) {
            String s1 = expand(str, i, i);
            String s2 = expand(str, i, i + 1);
            if (s1 != null && !s1.isEmpty()) {
                result.add(s1);
            }
            if (s2 != null && !s2.isEmpty()) {
                result.add(s2);
            }
        }
        return result;
    }

    private static String expand(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i + 1, j);
    }

    public static void main(String[] args) {
        String s = "aabcaaa";
        for (String palindrome : allPalindromes(s)) {
            System.out.println(palindrome);
        }
    }
}
