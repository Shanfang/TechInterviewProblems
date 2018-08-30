/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
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
