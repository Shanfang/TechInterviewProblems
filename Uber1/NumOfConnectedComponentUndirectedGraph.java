class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = buildGraph(edges, n);
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                visited[i] = true;
                markGraph(graph, i, visited);
            }
        }
        return count;
    }

    private void markGraph(Map<Integer, List<Integer>> graph, int cur, boolean[] visited) {
        for (int neighbor : graph.get(cur)) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                markGraph(graph, neighbor, visited);
            }
        }
    }

    private Map<Integer, List<Integer>> buildGraph(int[][] edges, int n) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0;i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int node1 = edges[i][0];
            int node2 = edges[i][1];

            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }
        return graph;
    }
}
