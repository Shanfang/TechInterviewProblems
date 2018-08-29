class Solution {
    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        int[] colors = new int[len];

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            if (colors[i] == 0) {
                colors[i] = 1;
                queue.offer(i);
            }
            while (!queue.isEmpty()) {
                int head = queue.poll();
                for (int j = 0; j < graph[head].length; j++) {
                    if (colors[graph[head][j]] == 0) {
                        colors[graph[head][j]] = -colors[head];
                        queue.offer(graph[head][j]);
                    } else if (colors[graph[head][j]] == colors[head]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
