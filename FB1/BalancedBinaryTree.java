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
    class Pair {
        int depth;
        boolean balanced;
        Pair(int d, boolean b) {
            depth = d;
            balanced = b;
        }
    }
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        Pair result = helper(root);
        return result.balanced;
    }

    private Pair helper(TreeNode root) {
        if (root == null) {
            return new Pair(0, true);
        }

        Pair leftP = helper(root.left);
        Pair rightP = helper(root.right);
        if (!leftP.balanced || !rightP.balanced) {
            return new Pair(0, false);
        }
        if (Math.abs(leftP.depth - rightP.depth) > 1) {
            return new Pair(0, false);
        }
        return new Pair(Math.max(leftP.depth, rightP.depth) + 1, true);
    }
}
