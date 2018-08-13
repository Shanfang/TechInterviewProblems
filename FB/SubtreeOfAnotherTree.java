/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // find same root then recursively compare each tree node
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return t == null;
        }

        if (s.val == t.val && sameTree(s, t)) {
            return true;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean sameTree(TreeNode s, TreeNode t) {
        if (s == null) {
            return t == null;
        }
        if (t == null) {
            return false;
        }
        return (s.val == t.val && sameTree(s.left, t.left) && sameTree(s.right, t.right));
    }
}
