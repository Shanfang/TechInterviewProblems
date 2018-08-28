/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode start) {
        if (start == null) {
            return null;
        }

        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        List<UndirectedGraphNode> nodes = getNodes(start);

        for (UndirectedGraphNode node : nodes) {
            map.put(node, new UndirectedGraphNode(node.label));
        }

        for (UndirectedGraphNode node : nodes) {
            UndirectedGraphNode newNode  = map.get(node);
            for (UndirectedGraphNode neighbor : node.neighbors) {
                newNode.neighbors.add(map.get(neighbor));
            }
        }
        return map.get(start);
    }

    private List<UndirectedGraphNode> getNodes(UndirectedGraphNode node) {
        List<UndirectedGraphNode> nodes = new ArrayList<>();
        Set<UndirectedGraphNode> set = new HashSet<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        set.add(node);

        while (!queue.isEmpty()) {
            UndirectedGraphNode head = queue.poll();
            nodes.add(head);
            for (UndirectedGraphNode neighbor : head.neighbors) {
                if (!set.contains(neighbor)) {
                    queue.offer(neighbor);
                    set.add(neighbor);
                }
            }
        }
        return nodes;
    }
}
