/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // recursive approach
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        List<Integer> leftSubtree = inorderTraversal(root.left);
        List<Integer> rightSubtree = inorderTraversal(root.right);
        for (int num : leftSubtree) {
            result.add(num);
        }
        result.add(root.val);
        for (int num : rightSubtree) {
            result.add(num);
        }
        return result;
    }
}
