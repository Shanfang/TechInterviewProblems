class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words == null || words.length == 0 ||
            s.length() < words.length * words[0].length()) {
            return result;
        }

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        Map<String, Integer> copy = new HashMap<>();

        int num = words.length;
        int wordLen = words[0].length();
        int counter = num;
        for (int i = 0; i <= s.length() - num * wordLen; i++) {
            int start = i;
            counter = num;
            copy.clear();
            while (start < i + num * wordLen) {
                String str = s.substring(start, start + wordLen);
                if (!map.containsKey(str)) {
                    break;
                }

                copy.put(str, copy.getOrDefault(str, 0) + 1);
                if (copy.get(str) > map.get(str)) {
                    break;
                }
                start += wordLen;
            }
            if (start == i + num * wordLen) {
                result.add(i);
            }
        }
        return result;
    }
}
