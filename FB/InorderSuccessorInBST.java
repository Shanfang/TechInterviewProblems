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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        } else {
            TreeNode successor = inorderSuccessor(root.left, p);
            return successor == null ? root : successor;
        }
    }
}

// iterative approach
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        while (root != null) {
            // successor must be in the right subtree
            if (root.val <= p.val) {
                root = root.right;
            } else {
                // root is a potential successor, although there are other successor that are closer to p
                successor = root;
                // move to the left subtree to find a potentially closer successor 
                root = root.left;
            }
        }
        return successor;
    }
}
