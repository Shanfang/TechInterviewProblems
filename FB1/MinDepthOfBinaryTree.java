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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftD = minDepth(root.left);
        int rightD = minDepth(root.right);
        if (leftD != 0 && rightD != 0) {
            return Math.min(leftD, rightD) + 1;
        }
        if (leftD == 0) {
            return rightD + 1;
        }
        return leftD + 1;
    }
}
