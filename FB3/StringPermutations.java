import java.util.*;
class StringPermutations {
    public List<String> allAnagrams(String str) {
        List<String> result = new ArrayList<>();
        if (str == null) {
            return result;
        }
        if (str.length() <= 1) {
            result.add(str);
            return result;
        }
        boolean[] used = new boolean[26];
        helper(str, "", used, result);
        return result;
    }

    private void helper(String str, String cur, boolean[] used, List<String> result) {
        if (str.length() == cur.length()) {
            result.add(cur);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!used[c - 'a']) {
                used[c - 'a'] = true;
                helper(str, cur + c, used, result);
                used[c - 'a'] = false;
            }
        }
    }

    public static void main(String[] args) {
        StringPermutations per = new StringPermutations();
        List<String> result = per.allAnagrams("abc");
        for (String str : result) {
            System.out.println(str);
        }
    }
}
