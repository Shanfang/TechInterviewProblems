public List<Integer> findIndex(String source, String target) {
    List<Integer> result = new ArrayList<>();
    if (source == null || source.length() < target.length()) {
        return result;
    }
    Map<Character, Integer> map = new HashMap<>();
    for (char c : target.toCharArray()) {
        map.put(c, map.getOrDefault(c, 0) + 1);
    }
    int counter = map.size();
    int start = 0, end = 0, len = source.length();
    while (end < len) {
        char c1 = source.charAt(end);
        if (map.containsKey(c1)) {
            map.put(c1, map.get(c1) - 1);
            if (map.get(c1) == 0) {
                counter--;
            }
        }
        end++;

        while (counter == 0) {
            if (end - start == target.length()) {
                result.add(start);
            }
            int char c2 = source.charAt(start);
            if (map.containsKey(c2)) {
                map.put(c1, map.get(c2) + 1);
                if (map.get(c1) > 0) {
                    counter++;
                }
            }
            start++;
        }
    }
    return result;
}
