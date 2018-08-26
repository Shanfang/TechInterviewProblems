class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for (char c : tasks) {
            counts[c - 'A']++;
        }

        Arrays.sort(counts);
        int intervals = 0;
        while (counts[25] > 0) {
            int timer = 0;
            while (timer <= n) {
                if (counts[25] == 0) {
                    break;
                }
                // timer <= n is not enough to guarantee counts index not going out of boundry.
                // think of crazy scenario, where interval is 1000, then timer needs to go to 1000,
                // but we only schedule one of the 26 tasks, this if statement need to check if there
                // is more tasks to run
                if (timer < 26 && counts[25 - timer] > 0) {
                    counts[25 - timer]--;
                }
                timer++;
                intervals++;
            }
            Arrays.sort(counts); // don't forget to sort it again, so that we find the task with most counts
        }
        return intervals;
    }
}


// use a max-heap, which is implemented as a priority queue to pick the most outstanding task
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for (char c : tasks) {
            counts[c- 'A']++;
        }

        Queue<Integer> maxHeap = new PriorityQueue<>(26, Collections.reverseOrder());
        for (int count : counts) {
            if (count != 0) {
                maxHeap.offer(count);
            }
        }

        int intervals = 0;
        while (!maxHeap.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int timer = 0;
            while (timer <= n) {
                if (!maxHeap.isEmpty()) {
                    if (maxHeap.peek() > 1) {
                        list.add(maxHeap.poll() - 1);
                    } else {
                    maxHeap.poll();
                    }
                }
                intervals++;

                if (maxHeap.isEmpty() && list.size() == 0) {
                    break;
                }
                timer++;
            }
            for (int num : list) {
                maxHeap.offer(num);
            }
        }
        return intervals;
    }
}
