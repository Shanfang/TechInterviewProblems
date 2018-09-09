/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        Set<UndirectedGraphNode> nodes = getAllNodes(node);
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        for (UndirectedGraphNode old : nodes) {
            map.put(old, new UndirectedGraphNode(old.label));
        }

        for (UndirectedGraphNode old : nodes) {
            UndirectedGraphNode newNode = map.get(old);
            //newNode.neighbors = new ArrayList<>(); // already created the neighbor list in the node constructor
            for (UndirectedGraphNode next : old.neighbors) {
                newNode.neighbors.add(map.get(next));
            }
        }
        return map.get(node);
    }

    private Set<UndirectedGraphNode> getAllNodes(UndirectedGraphNode node) {
        Set<UndirectedGraphNode> nodes = new HashSet<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            nodes.add(cur);
            for (UndirectedGraphNode neighbor : cur.neighbors) {
                if (!nodes.contains(neighbor)) {
                    queue.offer(neighbor);
                }
            }
        }
        return nodes;
    }
}
