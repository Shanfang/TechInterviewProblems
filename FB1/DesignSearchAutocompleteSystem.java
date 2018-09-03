class AutocompleteSystem {
    class TrieNode {
        Map<Character, TrieNode> children;
        Map<String, Integer> freq;
        boolean isWord;
        TrieNode () {
            children = new HashMap<>();
            freq = new HashMap<>();
            isWord = false;
        }
    }

    class Pair {
        String word;
        int occur;
        Pair(String str, int num) {
            this.word = str;
            this.occur = num;
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
            if (cur.children.get(c) == null) {
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
            cur.freq.put(word, cur.freq.getOrDefault(word, 0) + count);
        }
        cur.isWord = true;
    }
    public List<String> input(char c) {
        if (c == '#') {
            insert(prefix, 1);
            prefix = "";
            return new ArrayList<>();
        }
        prefix += c;
        TrieNode cur = root;
        for (char c1 : prefix.toCharArray()) {
            TrieNode child = cur.children.get(c1);
            if (child == null) {
                return new ArrayList<>();
            }
            cur = child;
        }

        Queue<Pair> queue = new PriorityQueue<>((a, b) -> (a.occur == b.occur ? a.word.compareTo(b.word) : b.occur - a.occur));
        for (String str : cur.freq.keySet()) {
            queue.offer(new Pair(str, cur.freq.get(str)));
        }

        List<String> result = new ArrayList<>();
        int i = 0;
        while (!queue.isEmpty() && i < 3) {
            result.add(queue.poll().word);
            i++;
        }
        return result;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
