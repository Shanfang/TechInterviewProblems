// BFS
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

// DFS
class Solution {
    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        int[] colors = new int[len];

        for (int i = 0; i < len; i++) {
            if (colors[i] == 0 && !validPaint(graph, colors, i, 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean validPaint(int[][] graph, int[] colors, int cur, int color) {
        if (colors[cur] != 0) {
            return colors[cur] == color; // if it has been painted, it should be the same color we wanna it to be
        }
        colors[cur] = color;
        for (int i = 0; i < graph[cur].length; i++) {
            if (colors[graph[cur][i]] == color) {
                return false;
            } else if (colors[graph[cur][i]] == 0) {
                 if (!validPaint(graph, colors, graph[cur][i], -color)) {
                     return false;
                 }
            }
        }
        return true;
    }
}
