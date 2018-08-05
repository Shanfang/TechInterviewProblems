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
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        findDepth(root);
        return maxDiameter;
    }

    private int findDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = findDepth(root.left);
        int rightDepth = findDepth(root.right);

        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
