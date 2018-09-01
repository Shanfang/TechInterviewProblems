class Solution {
    class Pair {
        String word;
        int freq;
        Pair(String str, int num) {
            word = str;
            freq = num;
        }
    }
    private Comparator pairComp = new Comparator<Pair>() {
        public int compare(Pair a, Pair b) {
            if (a.freq != b.freq) {
                return a.freq - b.freq;
            } else {
                return b.word.compareTo(a.word); // this order can't be flipped!!!
            }
        }
    };

    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        if (words == null || words.length == 0) {
            return result;
        }

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        Queue<Pair> queue = new PriorityQueue<Pair>(pairComp);

        for (String word : map.keySet()) {
            queue.offer(word);
            if (queue.size() > k) {
                queue.poll();
            }

            // actually, the following version runs faster, as we dont need to do extra work to sort it if a pair should not be on the queue
            // Pair top = queue.peek();
            // Pair newPair = new Pair(word, map.get(word));
            // if (queue.size() < k) {
            //     queue.offer(newPair);
            // } else {
            //     if (pairComp.compare(top, newPair) < 0) {
            //         queue.poll();
            //         queue.offer(newPair);
            //     }
            // }
        }

        while (!queue.isEmpty()) {
            result.add(queue.poll().word);
        }
        Collections.reverse(result);
        return result;
    }
}
