import java.util.*;

class MissingWords {
    // static List<String> findMissing(List<String> s, List<String> t) {
    //     List<String> result = new ArrayList<>();
    //     if (s == null || s.size() == 0) {
    //         return result;
    //     }
    //     if (t == null || t.size() == 0) {
    //         return s;
    //     }
    //     int i = 0, j = 0;
    //     while (i < s.size() && j < t.size()) {
    //         if (!s.get(i).equals(t.get(j))) {
    //             result.add(s.get(i));
    //             i++;
    //         } else {
    //             i++;
    //             j++;
    //         }
    //     }
    //     while (i < s.size()) {
    //         result.add(s.get(i));
    //         i++;
    //     }
    //     return result;
    // }
    static String findMissing(String s, String t) {
        if (s == null) {
            return null;
        }
        if (t == null) {
            return s;
        }
        String[] strs1 = s.split(" ");
        String[] strs2 = t.split(" ");
        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < strs1.length && j < strs2.length) {
            if (!strs1[i].equals(strs2[j])) {
                sb.append(strs1[i]).append(" ");
                i++;
            } else {
                i++;
                j++;
            }
        }
        while (i < strs1.length) {
            sb.append(strs1[i]).append(" ");
            i++;
        }
        return sb.toString().trim();
    }
    public static void main(String[] args) {
        String s = "a b b c d";
        String t = "b c";
        System.out.println(findMissing(s, t));
        // String[] strs1 = new String[]{"a","b", "b", "c", "d"};
        // String[] strs2 = new String[]{"b", "c"};
        // List<String> s = Arrays.asList(strs1);
        // List<String> t = Arrays.asList(strs2);
        // for (String str : findMissing(s, t)) {
        //     System.out.println(str);
        // }
    }
}
