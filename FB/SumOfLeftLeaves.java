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
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root, false);
    }

    private int helper(TreeNode node, boolean isLeft) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            if (isLeft) {
                return node.val;
            }
            return 0;
        }
        int leftCount = helper(node.left, true);
        int rightCount = helper(node.right, false);
        return leftCount + rightCount;
    }
}
