//DFS
class Solution {
    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        int[] colors = new int[len];
        for (int i = 0; i < len; i++) {
            if (colors[i] == 0 && !validColor(graph, colors, i, 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean validColor(int[][] graph, int[] colors, int node, int color) {
        if (colors[node] != 0) {
            return colors[node] == color;
        }

        colors[node] = color;
        for (int neighbor : graph[node]) {
            if (!validColor(graph, colors, neighbor, -color)) {
                return false;
            }
        }
        return true;
    }
}


// BFS
class Solution {
    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        int[] colors = new int[len];

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            if (colors[i] == 0) {
                queue.offer(i);
                colors[i] = 1;
                while (!queue.isEmpty()) {
                    int head = queue.poll();
                    for (int neighbor : graph[head]) {
                        if (colors[neighbor] == colors[head]) { // if any neighbor break the rule, return false
                            // don't return neighbor] != colors[head], this is not sufficient
                            return false;
                        } else if (colors[neighbor] == 0) {
                            queue.offer(neighbor);
                            colors[neighbor] = -colors[head];
                        }
                    }
                }
            }
        }
        return true;
    }
}
