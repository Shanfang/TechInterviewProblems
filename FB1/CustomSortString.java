class Solution {
    public String customSortString(String S, String T) {
        if (T == null || T.length() == 0 || S == null || S.length() == 0) {
            return T;
        }

        int[] buckets = new int[26];
        for (char c : T.toCharArray()) {
            buckets[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            while (buckets[c - 'a'] > 0) {
                sb.append(c);
                buckets[c - 'a']--;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (buckets[i] > 0) {
                while (buckets[i] > 0) {
                    sb.append((char)(i + 'a'));
                    buckets[i]--;
                }
            }
        }
        return sb.toString();
    }
}
/*
// this does not work!!! It does not overwrite the comparator??
class Solution {
    public String customSortString(String S, String T) {
        if (T == null || T.length() == 0 || S == null || S.length() == 0) {
            return T;
        }
        Map<Character, Integer> map = new HashMap<>();
        int index = 0;
        for (char c : S.toCharArray()) {
            map.put(c, index++);
        }

        Character[] array = new Character[T.length()];
        int i = 0;
        for (char c : T.toCharArray()) {
            array[i++] = c;
        }
        Arrays.sort(array, (a, b) -> (map.getOrDefault(a, -1) - map.getOrDefault(b, -1)));
        return String.valueOf(array);
    }
}*/
