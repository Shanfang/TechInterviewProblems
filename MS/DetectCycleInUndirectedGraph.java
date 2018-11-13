import java.util.*;

// the following code does not work!!!!
class UnionFind {
    Map<Integer, Integer> roots;

    UnionFind(int num) {
        roots = new HashMap<>();
        for (int i = 1; i <= num; i++) {
            roots.put(i, i);
        }
    }

    public int findRoot(int node) {
        // the following code will compress the path from node to root
        if (roots.get(node) != node) {
            roots.put(node, findRoot(roots.get(node)));
        }
        return roots.get(node);
    }
    public void union(int node1, int node2) {
        int root1 = findRoot(node1);
        int root2 = findRoot(node2);
        if (root1 != root2) {
            roots.put(root2, root1); // make root1 as the root the two sets of nodes
        }
    }
}

class Edge {
    int pointA;
    int pointB;
    Edge(int a, int b) {
        pointA = a;
        pointB = b;
    }

    public boolean equals(Edge e) {
        if (e.pointA == this.pointA && e.pointB == this.pointB) {
            return true;
        }
        return false;
    }
}
class DetectCycleInUndirectedGraph {
// using Disjointed Set
    public boolean hasCycle(Map<Integer, List<Integer>> graph, int nodeCount) {
        UnionFind uf = new UnionFind(nodeCount);

        Set<Edge> edges = getEdges(graph);
        for (Edge edge : edges) {
            int point1 = edge.pointA;
            int point2 = edge.pointB;
            int root1 = uf.findRoot(point1);
            int root2 = uf.findRoot(point2);
            if (root1 == root2) {
                System.out.println("find cycle " + root1 + " - " + root2);
                return true;
            }
            uf.union(root1, root2);
        }
        return false;
    }

    private Set<Edge> getEdges(Map<Integer, List<Integer>> graph) {
        Set<Edge> edges = new HashSet<>();
        for (int node : graph.keySet()) {
            for (int neighbor : graph.get(node)) {
                if (node > neighbor) {
                    int temp = node;
                    node = neighbor;
                    neighbor = temp;
                }
                edges.add(new Edge(node, neighbor));
            }
        }
        return edges;
    }

/*
// using DFS
    public boolean hasCycle(Map<Integer, List<Integer>> graph) {
        if (graph == null || graph.size() == 0) {
            return false;
        }
        boolean hasCycle = false;
        Set<Integer> visited = new HashSet<>();
        for (int node : graph.keySet()) {
            if (!visited.contains(node)) {
                hasCycle |= dfs(node, graph, visited, -1); // assume all the node are with val > 0
                if (hasCycle) {
                    break;
                }
            }
        }
        return hasCycle;
    }

    private boolean dfs(int node, Map<Integer, List<Integer>> graph, Set<Integer> visited, int parent) {
        visited.add(node);
        for (int neighbor : graph.get(node)) {
            if (neighbor == parent) {
                continue;
            }
            if (visited.contains(neighbor)) {
                return true;
            } else {
                boolean result = dfs(neighbor, graph, visited, node);
                if (result) {
                    return true;
                }
            }
        }
        return false;
    }
    */

    public static void main(String[] args) {
        DetectCycleInUndirectedGraph detect = new DetectCycleInUndirectedGraph();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i < 6; i++) {
            graph.put(i, new ArrayList<>());
        }

        graph.get(1).add(4);
        graph.get(1).add(2);
        graph.get(2).add(1);
        graph.get(2).add(3);
        graph.get(2).add(5);
        graph.get(3).add(2);
        graph.get(4).add(1);
        // graph.get(4).add(5);
        // graph.get(5).add(4);
        graph.get(5).add(2);
        //graph.get(6).add(6); // create a connected component of one node
        // System.out.println(detect.hasCycle(graph));
        System.out.println(detect.hasCycle(graph, 5));
    }
}
