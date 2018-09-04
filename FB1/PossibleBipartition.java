// the map k-v pair, arraylist is faster than a hashset for the value
// getOrDefault does not work!!!
class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        //Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < dislikes.length; i++) {
            int first = dislikes[i][0];
            int second = dislikes[i][1];
            if (!map.containsKey(first)) {
                map.put(first, new HashSet<>());
            }
            map.get(first).add(second);
            if (!map.containsKey(second)) {
                map.put(second, new HashSet<>());
            }
            map.get(second).add(first);
            // NOTE!!! fetOrDefault does not work for non-primitive type
            //map.getOrDefault(first, new HashSet<>()).add(second);
            //map.getOrDefault(second, new HashSet<>()).add(first);
        }
        int[] colors = new int[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        int start = 0;
        for (int i = 1; i <= N; i++) {
            if (map.containsKey(i) && colors[i] == 0) {
                queue.offer(i);
                colors[i] = 1;
                while (!queue.isEmpty()) {
                    int head = queue.poll();
                    for (int neighbor : map.get(head)) {
                        if (colors[neighbor] == 0) {
                            colors[neighbor] = -colors[head];
                            queue.offer(neighbor);
                        } else if (colors[head] == colors[neighbor]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
