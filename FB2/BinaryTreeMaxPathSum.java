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
    public int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum1 = fromRoot(root);
        return Math.max(maxSum, sum1);
    }

    private int fromRoot(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = fromRoot(root.left);
        int rightSum = fromRoot(root.right);
        int newMax = Math.max(leftSum, 0) + Math.max(rightSum, 0) + root.val;
        if (newMax > maxSum) {
            maxSum = newMax;
        }
        return Math.max(Math.max(leftSum, rightSum), 0) + root.val;
    }
}
