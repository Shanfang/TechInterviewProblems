import java.util.*;

class FirstNonDuplicateChar {
    static char findChar(String str) throws Exception {
        int[] map = new int[26];
        for (char c : str.toCharArray()) {
            map[c - 'a']++;
        }
        char result = '#';
        for (char c : str.toCharArray()) {
            if (map[c - 'a'] == 1) {
                result = c;
                break;
            }
        }
        if (result != '#') {
            return result;
        } else {
            throw new Exception("No non-duplicate char");
        }
    }

    public static void main(String[] agrs) {
        String str = "aabadcsedb";

        try {
            System.out.println(findChar(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
