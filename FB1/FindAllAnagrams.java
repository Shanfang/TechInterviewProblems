// use slide window template
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() < p.length()) {
            return result;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int start = 0, end = 0;
        int counter = map.size();
        while (end < s.length()) {
            char c1 = s.charAt(end);
            if (map.containsKey(c1)) {
                map.put(c1, map.get(c1) - 1);
                if (map.get(c1) == 0) {
                    counter--;
                }
            }
            end++;

            while (counter == 0) {
                char c2 = s.charAt(start);
                if (map.containsKey(c2)) {
                    map.put(c2, map.get(c2) + 1);
                    if (map.get(c2) > 0) {
                        counter++;
                    }
                }
                if (end - start == p.length()) {
                    result.add(start);
                }
                start++;
            }
        }
        return result;
    }
}

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() < p.length()) {
            return result;
        }

        int[] dict = new int[128];
        for (char c : p.toCharArray()) {
            dict[c]++;
        }

        int pLen = p.length();
        int need = pLen;
        int start = 0, end = 0;
        while (end < s.length()) {
            if (dict[s.charAt(end)] >= 1) {
                need--;
            }
            dict[s.charAt(end)]--;
            end++;
            if (need == 0) {
                result.add(start);
            }

            if (end - start == pLen) {
                if (dict[s.charAt(start)] >= 0) {
                    need++;
                }
                dict[s.charAt(start)]++;
                start++;
            }
        }
        return result;
    }
}
