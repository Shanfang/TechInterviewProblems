import java.util.*;

class LongestString {
    static String longest(List<String> list, String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        int[] map = new int[26];
        for (char c : str.toCharArray()) {
            map[c - 'a']++;
        }

        int maxLen = 0;
        String result = "";
        for (int i = 0; i < list.size(); i++) {
            int[] counter = new int[26];
            for (int j = 0; j < 26; j++) {
                counter[j] = map[j];
            }

            String str1 = list.get(i);
            for (char c : str1.toCharArray()) {
                counter[c - 'a']--;
            }
            if (valid(counter)) {
                if (str1.length() > maxLen) {
                    maxLen = str1.length();
                    result = str1;
                }
            }
        }
        return result;
    }

    static boolean valid(int[] counter) {
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] arr = {"acc", "a", "ac"};
        List<String> list = Arrays.asList(arr);
        String str = "ac";
        System.out.println(longest(list, str));
    }
}
