/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // preorder traversal
 class Solution {
     public void flatten(TreeNode root) {
         if (root == null) {
             return;
         }

         Stack<TreeNode> stack = new Stack<>();
         stack.push(root);
         while (!stack.isEmpty()) {
             TreeNode cur = stack.pop();
             if (cur.right != null) {
                 stack.push(cur.right);
             }
             if (cur.left != null) {
                 stack.push(cur.left);
             }
             cur.left = null;
             if (stack.isEmpty()) {
                 cur.right = null;
             } else {
                 cur.right = stack.peek();
             }
         }
     }
 }

// recursive approach
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        helper(root);
    }

    private TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftList = helper(root.left);
        TreeNode rightList = helper(root.right);
        root.left = null;
        TreeNode cur = leftList;
        if (cur == null) {
            root.right = rightList;
            return root;
        }
        while (cur.right != null) {
            cur = cur.right;
        }
        root.right = leftList;
        cur.right = rightList;
        return root;
    }
}
