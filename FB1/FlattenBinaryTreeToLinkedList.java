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
