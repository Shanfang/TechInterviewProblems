class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return result;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = map.size();

        int i = 0;
        int left = 0;
        while (i < s.length()) {
            char c1 = s.charAt(i);
            if (map.containsKey(c1)) {
                map.put(c1, map.get(c1) - 1);
                if (map.get(c1) == 0) {
                    count--;
                }
            }
            i++;

            while (count == 0) {
                if (i - left == p.length()) {
                    result.add(left);
                }
                char c2 = s.charAt(left);
                if (map.containsKey(c2)) {
                    map.put(c2, map.get(c2) + 1);
                    if (map.get(c2) > 0) {
                        count++;
                    }
                }
                left++;
            }
        }
        return result;
    }
}
