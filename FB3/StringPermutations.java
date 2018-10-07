import java.util.*;
class StringPermutations {
    // this is the version I came up during the interview
    // this only works if the string does not have duplicate chars
    // otherwise, map should increment/decrement, checkout StringPermutations2    
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
            map[c - 'a'] = 1;
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
                map[i] = 0;
                helper(str, cur + (char)('a' + i), map, result); // must use casting here!!
                map[i] = 1;
            }
        }
    }
    // public List<String> allAnagrams(String str) {
    //     List<String> result = new ArrayList<>();
    //     if (str == null) {
    //         return result;
    //     }
    //     if (str.length() <= 1) {
    //         result.add(str);
    //         return result;
    //     }
    //     boolean[] used = new boolean[26];
    //     helper(str, "", used, result);
    //     return result;
    // }
    //
    // private void helper(String str, String cur, boolean[] used, List<String> result) {
    //     if (str.length() == cur.length()) {
    //         result.add(cur);
    //         return;
    //     }
    //
    //     for (int i = 0; i < str.length(); i++) {
    //         char c = str.charAt(i);
    //         if (!used[c - 'a']) {
    //             used[c - 'a'] = true;
    //             helper(str, cur + c, used, result);
    //             used[c - 'a'] = false;
    //         }
    //     }
    // }

    public static void main(String[] args) {
        StringPermutations per = new StringPermutations();
        List<String> result = per.allAnagrams("abc");
        for (String str : result) {
            System.out.println(str);
        }
    }
}
