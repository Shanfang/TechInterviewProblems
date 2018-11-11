import java.util.*;

class DetectCycleInUndirectedGraph {
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

    public static void main(String[] args) {
        DetectCycleInUndirectedGraph detect = new DetectCycleInUndirectedGraph();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= 6; i++) {
            graph.put(i, new ArrayList<>());
        }

        graph.get(1).add(4);
        graph.get(1).add(2);
        graph.get(2).add(1);
        graph.get(2).add(3);
        graph.get(2).add(5);
        graph.get(3).add(2);
        graph.get(4).add(1);
        //graph.get(4).add(5);
        //graph.get(5).add(4);
        graph.get(5).add(2);
        //graph.get(6).add(6); // create a connected component of one node
        System.out.println(detect.hasCycle(graph));
    }
}
