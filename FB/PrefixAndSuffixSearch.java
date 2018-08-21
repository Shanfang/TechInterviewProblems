// scenario: f method is used more frequently, it takes time to initialize the data structure
class WordFilter {
    Map<String, Integer> map;
    public WordFilter(String[] words) {
        map = new HashMap<>();

        // build the key with prefix-suffix pair
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j <= word.length(); j++) {
                for (int k = word.length(); k >= 0; k--) {
                    map.put(word.substring(0, j) + "#" + word.substring(word.length() - k), i);
                }
            }
        }
    }

    public int f(String prefix, String suffix) {
        return map.getOrDefault(prefix + "#" + suffix, -1);
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
