class WordDictionary {
    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        TrieNode() {
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
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return isMatch(word.toCharArray(), 0, root);
    }

    private boolean isMatch(char[] chars, int start, TrieNode cur) {
        if (start == chars.length) {
            return cur.isWord;
        }

        if (chars[start] != '.') {
            return cur.children[chars[start] - 'a'] != null && isMatch(chars, start + 1, cur.children[chars[start] - 'a']);
        } else {
            for (int i = 0; i < 26; i++) {
                if (cur.children[i] != null && isMatch(chars, start + 1, cur.children[i])) {
                    return true;
                }
            }
        }
        return false;
    }
}


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
