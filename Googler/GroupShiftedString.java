class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<>();
        if(strings == null || strings.length == 0) {
            return result;
        }

        Map<String, List<String>> map = new HashMap<>();
        int[] count = new int[26];
        for (String str : strings) {
            StringBuilder sb = new StringBuilder();
            char c0 = str.charAt(0);
            for (char c : str.toCharArray()) {
                sb.append((c - c0 + 26) % 26).append('#');

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
