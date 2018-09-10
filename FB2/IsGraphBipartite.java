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
        colors[cur] = color;
        for (int i = 0; i < graph[cur].length; i++) {
            if (colors[graph[cur][i]] == color) {
                return false;
            } else if (colors[graph[cur][i]] == -color) {
                continue;
            } else if (colors[graph[cur][i]] == 0) {
                 if (!validPaint(graph, colors, graph[cur][i], -color)) {
                     return false;
                 }
            }
        }
        return true;
    }
}
