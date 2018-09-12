class Solution {
    class Pair {
        String word;
        int freq;
        Pair(String str, int f) {
            this.word = str;
            this.freq = f;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        Queue<Pair> minHeap = new PriorityQueue(new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                if (a.freq == b.freq) {
                    return b.word.compareTo(a.word);
                }
                return a.freq - b.freq;
            }
        });
        for (String word : map.keySet()) {
            minHeap.offer(new Pair(word, map.get(word)));
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll().word);
        }
        Collections.reverse(result);
        return result;
    }
}
