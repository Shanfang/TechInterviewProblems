// union find
class Solution {
    public int countComponents(int n, int[][] edges) {
        if (n <= 1) {
            return n;
        }
        int[] roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }

        int count = n;
        for (int i = 0; i < edges.length; i++) {
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            int root1 = findRoot(roots, node1);
            int root2 = findRoot(roots, node2);
            if (root1 != root2) {
                count--;
                roots[root1] = root2;
            }
        }
        return count;
    }

    private int findRoot(int[] roots, int node) {
        int temp = node;
        while (roots[node] != node) {
            node = roots[node];
        }

        while (roots[temp] != node) {
            int parent = roots[temp];
            roots[temp] = node;
            temp = parent;
        }
        return node;
    }
}

// build graph then traversal
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
