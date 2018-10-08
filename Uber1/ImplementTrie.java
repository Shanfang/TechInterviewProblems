class Trie {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord;
    }
    /** Initialize your data structure here. */
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] chars = word.toCharArray();
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (cur.children[chars[i] - 'a'] == null) {
                cur.children[chars[i] - 'a'] = new TrieNode();
            }
            cur = cur.children[chars[i] - 'a'];
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (cur.children[chars[i] - 'a'] == null) {
                return false;
            }
            cur = cur.children[chars[i] - 'a'];
        }
        return cur.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (cur.children[chars[i] - 'a'] == null) {
                return false;
            }
            cur = cur.children[chars[i] - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
