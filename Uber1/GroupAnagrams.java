// better time complexity O(N*L)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return result;
        }
        int[] counter = new int[26];
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            Arrays.fill(counter, 0);
            for (char c : str.toCharArray()) {
                counter[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append(counter[i]).append(',');
            }
            String key = sb.toString();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }

        result.addAll(map.values());
        return result;
    }
}

// sort each string, time complexity is O(N*LlogL), where N is number of strings, and L is length of string
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return result;
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        result.addAll(map.values());
        return result;
    }
}
