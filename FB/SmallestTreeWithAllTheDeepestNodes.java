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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) {
            return null;
        }

        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        if (leftDepth == rightDepth) {
            return root;
        }
        if (leftDepth > rightDepth) {
            return subtreeWithAllDeepest(root.left);
        }
        return subtreeWithAllDeepest(root.right);
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }
}
