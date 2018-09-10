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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        TreeNode leftSub = lowestCommonAncestor(root.left, p, q);
        TreeNode rightSub = lowestCommonAncestor(root.right, p, q);
        if (leftSub != null && rightSub != null) {
            return root;
        }
        if (root == p || root == q) {
            return root;
        }

        if (leftSub != null) {
            return leftSub;
        }
        if (rightSub != null) {
            return rightSub;
        }
        return null;
    }
}
