class AutocompleteSystem {
    class TrieNode {
        Map<Character, TrieNode> children;
        Map<String, Integer> freq;
        boolean isWord;

        public TrieNode() {
            children = new HashMap<>();
            freq = new HashMap<>();
            isWord = false;
        }
    }

    class Pair {
        String word;
        int frequency;
        public Pair (String s, int f) {
            this.word = s;
            this.frequency = f;
        }
    }

    TrieNode root;
    String prefix;
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        prefix = "";
        for (int i = 0; i < sentences.length; i++) {
            insert(sentences[i], times[i]);
        }
    }

    private void insert(String word, int count) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            TrieNode next = cur.children.get(c);
            if (next == null) {
                next = new TrieNode();
                cur.children.put(c, next);
            }
            cur = next;
            cur.freq.put(word, cur.freq.getOrDefault(word, 0) + count);
        }
        cur.isWord = true;
    }


    public List<String> input(char c) {
        if (c == '#') {
            insert(prefix, 1);
            prefix = "";
            return new ArrayList<String>();
        }

        prefix = prefix + c;
        TrieNode cur = root;
        for (char ch : prefix.toCharArray()) {
            TrieNode next = cur.children.get(ch);
            if (next == null) {
                return new ArrayList<>();
            }
            cur = next;
        }

        Queue<Pair> maxHeap = new PriorityQueue<>(
                        (a, b) -> (a.frequency == b.frequency ? a.word.compareTo(b.word) : b.frequency - a.frequency));

        for (String str : cur.freq.keySet()) {
            maxHeap.add(new Pair(str, cur.freq.get(str)));
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < 3 && !maxHeap.isEmpty(); i++) {
            result.add(maxHeap.poll().word);
        }
        return result;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
