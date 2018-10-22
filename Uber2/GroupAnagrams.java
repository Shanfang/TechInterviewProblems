// counting sort to get key for a group of anagrams
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        int[] count = new int[26];
        for (String str : strs) {
            Arrays.fill(count, 0);
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i< 26; i++) {
                if (count[i] > 0) {
                    sb.append((char)(i + 'a')).append(count[i]).append('#');
                }
            }
            String key = sb.toString();
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        result.addAll(map.values());
        return result;
    }
}

// O(N*LlogL) time complexity
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        result.addAll(map.values());
        return result;
    }
}
