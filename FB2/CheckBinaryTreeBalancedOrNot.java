/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
class Pair {
    int height;
    boolean isBalanced;
    Pair(int h, boolean balanced) {
        height = h;
        isBalanced = balanced;
    }
}
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */

    public boolean isBalanced (TreeNode root) {
        if (root == null) {
            return true;
        }

        return helper(root).isBalanced;
    }

    private Pair helper(TreeNode root) {
        if (root == null) {
            return new Pair(0, true);
        }

        Pair leftSub = helper(root.left);
        Pair rightSub = helper(root.right);
        if (!leftSub.isBalanced || !rightSub.isBalanced) {
            return new Pair(0, false);
        }
        if (Math.abs(leftSub.height - rightSub.height) > 1) {
            return new Pair(0, false);
        }
        return new Pair(Math.max(leftSub.height, rightSub.height) + 1, true);
    }
}
