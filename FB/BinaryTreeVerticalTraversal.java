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
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> nodeQ = new LinkedList<>();
        Queue<Integer> indexQ = new LinkedList<>();
        Map<Integer, List<Integer>> map = new TreeMap<>();
        nodeQ.offer(root);
        indexQ.offer(0);

        while (!nodeQ.isEmpty()) {
            TreeNode node = nodeQ.poll();
            int index = indexQ.poll();
            map.putIfAbsent(index, new ArrayList<>());
            map.get(index).add(node.val);

            if (node.left != null) {
                nodeQ.offer(node.left);
                indexQ.offer(index - 1);
            }

            if (node.right != null) {
                nodeQ.offer(node.right);
                indexQ.offer(index + 1);
            }
        }

        for (int index : map.keySet()) {
            result.add(map.get(index));
        }
        return result;
    }
}
