class WordDictionary {
    class TrieNode {
        TrieNode[] children;
        boolean isWord;

        TrieNode () {
            children = new TrieNode[26];
            isWord = false;
        }
    }

    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int j = word.charAt(i) - 'a';
            if (node.children[j] == null) {
                node.children[j] = new TrieNode();
            }
            node = node.children[j];
        }
        node.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (c == '.') {
                for (int k = 0; k < 26; k++) {
                    if (search(word.substring(0, i) + (char)('a' + k) + word.substring(i + 1))) {
                        return true;
                    }
                }
                return false;
            } else  {
                if (node.children[c - 'a'] != null) {
                    node = node.children[c - 'a'];
                } else {
                    return false;
                }
            }
        }
        return node.isWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
