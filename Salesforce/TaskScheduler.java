class Solution {
    class Pair {
        char c;
        int count;
        Pair(char c, int num) {
            this.c = c;
            this.count = num;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Queue<Pair> maxHeap = new PriorityQueue<>((a, b) -> b.count - a.count);
        for (char key : map.keySet()) {
            maxHeap.offer(new Pair(key, map.get(key)));
        }

        int interval = 0;
        int timer = 0;
        while (!maxHeap.isEmpty()) {
            timer = 0;
            List<Character> list = new ArrayList<>();
            while (timer <= n && !maxHeap.isEmpty()) {
                Pair pair = maxHeap.poll();
                map.put(pair.c, map.get(pair.c) - 1);
                if (map.get(pair.c) > 0) {
                    list.add(pair.c);
                }
                timer++;
                interval++;
            }
            if (list.size() == 0 && maxHeap.isEmpty()) {
                break;
            }
            while (maxHeap.isEmpty() && timer <= n) {
                timer++;
                interval++;
            }
            for (char c : list) {
                maxHeap.offer(new Pair(c, map.get(c)));
            }
        }
        return interval;
    }
}
