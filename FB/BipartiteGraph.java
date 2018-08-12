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
