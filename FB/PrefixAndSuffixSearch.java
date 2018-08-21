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

// scenario: use less space but with high time complexity
class WordFilter {
    TrieNode root;
    public WordFilter(String[] words) {
        root = new TrieNode();

        for (int i = 0; i < words.length; i++) {
            String word = words[i] + "{";
            for (int j = 0; j < word.length(); j++) {
                TrieNode node = root;
                node.weight = i;
                for (int k = j; k < 2 * word.length() - 1; k++) {
                    int idx = word.charAt(k % word.length()) - 'a';
                    if (node.children[idx] == null) {
                        node.children[idx] = new TrieNode();
                    }
                    node = node.children[idx];
                    node.weight = i;
                }

            }
        }
    }

    public int f(String prefix, String suffix) {
        TrieNode node = root;
        for (char c : (suffix + "{" + prefix).toCharArray()) {
            if (node.children[c - 'a'] == null) {
                return -1;
            }
            node = node.children[c - 'a'];
        }
        return node.weight;
    }

    class TrieNode {
        TrieNode[] children;
        int weight;
        TrieNode() {
            children = new TrieNode[27];
            weight = 0;
        }
    }
}
/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
