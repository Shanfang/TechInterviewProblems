/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // use binary tree inorder traversal, but this approach has o(n) space complexity
class Solution {
    private TreeNode firstNode = null;
    private TreeNode secondNode = null;
    private TreeNode preNode = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root);
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left);
        if (firstNode == null && preNode.val >= root.val) {
            firstNode = preNode;
        }
        if (firstNode != null && preNode.val >= root.val) {
            secondNode = root;
        }

        preNode = root;
        inorderTraversal(root.right);
    }
}
