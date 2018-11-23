import java.util.*;

class FindCommonChar {
    // this takes O(N) time and O(N) space
    // static List<Character> find(String str1, String str2) {
    //     List<Character> result = new ArrayList<>();
    //     if (str1 == null || str1.length() == 0 || str2 == null || str2.length() == 0) {
    //         return result;
    //     }
    //
    //     Set<Character> set = new HashSet<>();
    //     Set<Character> set1 = new HashSet<>();
    //     for (char c : str1.toCharArray()) {
    //         set.add(c);
    //     }
    //
    //     for (char c : str2.toCharArray()) {
    //         if (set.contains(c)) {
    //             set1.add(c);
    //         }
    //     }
    //     return new ArrayList<>(set1);
    // }

// this takes O(NlgN) time and const space
    static List<Character> find(String str1, String str2) {
        List<Character> result = new ArrayList<>();
        if (str1 == null || str1.length() == 0 || str2 == null || str2.length() == 0) {
            return result;
        }

        Set<Character> set = new HashSet<>();
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);

        int i = 0, j = 0;
        while (i < chars1.length && j < chars2.length) {
            if (chars1[i] < chars2[j]) {
                i++;
            } else if (chars1[i] > chars2[j]) {
                j++;
            } else  {
                set.add(chars1[i]);
                i++;
                j++;
            }
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        String str1 = "Happy Thanksgiving!";
        String str2 = "Happy Holiday!";
        for (char c : find(str1, str2)) {
            System.out.println(c);
        }
    }
}
