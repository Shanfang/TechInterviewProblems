/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// without treemap
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Map<Integer, List<Integer>> colMap = new HashMap<>();
        Map<TreeNode, Integer> distMap = new HashMap<>();
        Queue<TreeNode> queue = new ArrayDeque<>();

        distMap.put(root, 0);
        queue.offer(root);
        int leftMost = 0;
        while (!queue.isEmpty()) {
            TreeNode head = queue.poll();
            int dist = distMap.get(head);
            List<Integer> list = colMap.getOrDefault(dist, new ArrayList<>());
            list.add(head.val);
            colMap.put(dist, list);

            if (head.left != null) {
                queue.offer(head.left);
                distMap.put(head.left, dist - 1);
            }
            if (head.right != null) {
                queue.offer(head.right);
                distMap.put(head.right, dist + 1);
            }
            leftMost = Math.min(leftMost, dist);
        }
        while (colMap.containsKey(leftMost)) {
            result.add(colMap.get(leftMost));
            leftMost++;
        }
        return result;
    }
}

 // with treemap for ordering
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> distQueue = new LinkedList<>();
        nodeQueue.offer(root);
        distQueue.offer(0);
        while (!nodeQueue.isEmpty()) {
            TreeNode head = nodeQueue.poll();
            int dist = distQueue.poll();
            List<Integer> list = map.getOrDefault(dist, new ArrayList<>());
            list.add(head.val);
            map.put(dist, list);

            if (head.left != null) {
                nodeQueue.offer(head.left);
                distQueue.offer(dist - 1);
            }
            if (head.right != null) {
                nodeQueue.offer(head.right);
                distQueue.offer(dist + 1);
            }
        }
        for (int key : map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }
}
