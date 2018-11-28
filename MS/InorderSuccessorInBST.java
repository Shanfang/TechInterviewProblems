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
    TreeNode suc = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return suc;
        }
        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        } else if (root.val > p.val){
            suc = root;
            return inorderSuccessor(root.left, p);
        }
        return suc;
    }
}
