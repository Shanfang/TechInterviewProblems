import java.util.*;

class SimpleAutoComplete {
    class TrieNode {
        TrieNode[] children;
        List<String> prefixWords;
        boolean isWord;

        TrieNode() {
            children = new TrieNode[26];
            prefixWords = new ArrayList<>();
        }
    }
    TrieNode root;
    SimpleAutoComplete() {
        root = new TrieNode();
    }
    private void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
            cur.prefixWords.add(word);
        }
        cur.isWord = true;
    }

    private List<String> search(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                return new ArrayList<>();
            }
            cur = cur.children[c - 'a'];
        }
        return cur.prefixWords;
    }

    public static void main(String[] args) {
        SimpleAutoComplete auto = new SimpleAutoComplete();
        auto.insert("hello");
        auto.insert("help");
        auto.insert("helper");
        auto.insert("hi");
        for (String str : auto.search("help")) {
            System.out.println(str);
        }
    }
}
