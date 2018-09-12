import java.util.*;
class StringPermutations2 {
    // this is the version I came up during the interview
    public List<String> allAnagrams(String str) {
        List<String> result = new ArrayList<>();
        if (str == null) {
            return result;
        }
        if (str.length() <= 1) {
            result.add(str);
            return result;
        }
        int[] map = new int[26];
        for (char c : str.toCharArray()) {
            map[c - 'a']++;
        }
        helper(str, "", map, result);
        return result;
    }

    private void helper(String str, String cur, int[] map, List<String> result) {
        if (str.length() == cur.length()) {
            result.add(cur);
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (map[i] > 0) {
                map[i]--;
                helper(str, cur + (char)('a' + i), map, result); // must use casting here!!
                map[i]++;
            }
        }
    }

    public static void main(String[] args) {
        StringPermutations2 per = new StringPermutations2();
        List<String> result = per.allAnagrams("aaabc");
        for (String str : result) {
            System.out.println(str);
        }
    }
}
