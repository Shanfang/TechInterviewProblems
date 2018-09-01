class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        for (String word : wordList) {
            dict.add(word);
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int len = 0;
        while (!queue.isEmpty()) {
            len++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return len;
                }
                for (String next : expand(word, dict)) {
                    queue.offer(next);
                }
                dict.remove(word);
            }
        }
        return 0;
    }

    private List<String> expand(String word, Set<String> dict) {
        List<String> result = new ArrayList<>();
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (char c = 'a'; c < 'z'; c++) {
                if (c == chars[i]) {
                    continue;
                }
                char original = chars[i];
                chars[i] = c;
                String newWord = String.valueOf(chars);
                if (dict.contains(newWord)) {
                    result.add(newWord);
                }
                chars[i] = original;
            }
        }
        return result;
    }
}
