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
