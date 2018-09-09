// improved by storing word in the last trie node in the path, mark it null if visited
// NOTE:  the dfs base case is: either we are at a visited position, or we readed the end of the path in trie
// we can't return after find one word!!! it is possible there are other words along the path downwards
class Solution {
    class TrieNode{
        TrieNode[] children;
        String word;
        TrieNode() {
            children = new TrieNode[26];
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();

        for (String word : words) {
            insertWord(root, word);
        }

        List<String> result = new ArrayList<>();
        for (int i = 0 ; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(board, i, j, root, result);
            }
        }
        return result;
    }

    private void insertWord(TrieNode root, String str) {
        TrieNode cur = root;
        for (char c : str.toCharArray()) {
            if (cur.children[c- 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.word = str;
    }
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    private void dfs(char[][] board, int i, int j, TrieNode cur, List<String> result) {
        char c = board[i][j];
        if (c == '#' || cur.children[c - 'a'] == null) {
            return;
        }
        cur = cur.children[c - 'a'];
        if (cur.word != null) {
            result.add(cur.word);
            cur.word = null; // can't return after find this word
        }

        board[i][j] = '#';
        for (int k = 0; k < 4; k++) {
            int newX = i + dx[k];
            int newY = j + dy[k];
            if (inBound(board, newX, newY)) {
                dfs(board, newX, newY, cur, result);
            }
        }
        board[i][j] = c;
    }

    private boolean inBound(char[][] board, int i, int j) {
        return i >= 0 && i < board.length && j >= 0 && j < board[i].length;
    }
}



// use StringBuilder and Trie class
class Solution {
    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        TrieNode() {
            children = new TrieNode[26];
        }
    }

    public class Trie {
        private TrieNode root;
        public Trie () {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode cur = root;

            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            }
            cur.isWord = true;
        }

        public boolean search(String word) {
            TrieNode cur = root;

            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    return false;
                }
                cur = cur.children[c - 'a'];
            }
            return cur.isWord;
        }

        public boolean startWith(String word) {
            TrieNode cur = root;
           for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    return false;
                }
                cur = cur.children[c - 'a'];
            }
            return true;
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        HashSet<String> result = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (trie.startWith(board[i][j] + "")) {
                    StringBuilder sb = new StringBuilder("" + board[i][j]);
                    board[i][j] ^= 256;
                    dfs(trie, result, board, i, j, sb);
                    board[i][j] ^= 256;
                }
            }
        }
        return new ArrayList<>(result);
    }

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    private void dfs(Trie trie, HashSet<String> result, char[][] board, int i, int j, StringBuilder sb) {
        if (trie.search(sb.toString())) {
            result.add(sb.toString());
        }

        for (int k = 0; k < 4; k++) {
            int newX = i + dx[k];
            int newY = j + dy[k];
            if (newX < 0 || newX >= board.length || newY < 0 || newY >= board[0].length ||
                board[newX][newY] < 'a' || board[newX][newY] > 'z') {
                continue;
            }
            if (!trie.startWith(sb.append(board[newX][newY]).toString())) {
                sb.deleteCharAt(sb.length() - 1);
                continue;
            }

            board[newX][newY] ^= 256;
            dfs(trie, result, board, newX, newY, sb);
            board[newX][newY] ^= 256;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}


/*
    when doing dfs, if we need to check some conditions before go deep into next recursion
    Be careful when using stringbuilder. It is easy to bring in bugs like Nullpointer issue.
    string concatenation is slow, but it works!!!
    Also, get the string or sb before marking the board to some other charater, this caused null pointer issue!!
    some char with ASCII > 26 appears and causes null pointer in search()
// the following solution uses string concatenation
class Solution {
    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        TrieNode() {
            children = new TrieNode[26];
        }
    }

    public class Trie {
        private TrieNode root;
        public Trie () {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode cur = root;
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
            //for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            }
            cur.isWord = true;
        }

        public boolean search(String word) {
            TrieNode cur = root;
            System.out.println("word " + word);

            //for (char c : word.toCharArray()) {
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (c < 'a' || c > 'z') {
                    return false;
                }
                if (cur.children[c - 'a'] == null) {
                    return false;
                }
                cur = cur.children[c - 'a'];
            }
            return cur.isWord;
        }

        public boolean startWith(String word) {
            TrieNode cur = root;
           // for (char c : word.toCharArray()) {
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (c < 'a' || c > 'z') {
                    return false;
                }
                if (cur.children[c - 'a'] == null) {
                    return false;
                }
                cur = cur.children[c - 'a'];
            }
            return true;
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        HashSet<String> result = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                //System.out.print("in main function board is: "  +  board[i][j]);

                if (trie.startWith(board[i][j] + "")) {
                    String str = board[i][j] + "";
                    //System.out.println("in main function str is: "  +  str);
                    board[i][j] ^= 256;
                    dfs(trie, result, board, i, j, str);
                    board[i][j] ^= 256;
                }
            }
        }
        return new ArrayList<>(result);
    }

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    private void dfs(Trie trie, HashSet<String> result, char[][] board, int i, int j, String str) {
        System.out.println("in dfs function str is: "  +  str);

        if (trie.search(str)) {
            result.add(str);
        }

        for (int k = 0; k < 4; k++) {
            int newX = i + dx[k];
            int newY = j + dy[k];
            if (newX < 0 || newX >= board.length || newY < 0 || newY >= board[0].length ||
                board[newX][newY] < 'a' || board[newX][newY] > 'z' || !trie.startWith(str + board[newX][newY])) {
                continue;
            }
            // if (!trie.startWith(sb.append(board[newX][newY]).toString()) {
            //     sb.deleteCharAt(sb.length() - 1);
            //     continue;
            // }
            System.out.println("in dfs function new str is: "  +  str + board[newX][newY]);
            String newStr = str + board[newX][newY];
            board[newX][newY] ^= 256;
            dfs(trie, result, board, newX, newY, newStr);
            board[newX][newY] ^= 256;
            //sb.deleteCharAt(sb.length() - 1);
        }
    }
}
*/
