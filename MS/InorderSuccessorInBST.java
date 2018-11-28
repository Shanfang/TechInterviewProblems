/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // use global var suc
 class Solution {
     TreeNode suc = null;
     public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
         if (root == null) {
             return suc;
         }
         if (root.val <= p.val) {
             inorderSuccessor(root.right, p);
         } else if (root.val > p.val){
             suc = root;
             inorderSuccessor(root.left, p);
         }
         return suc;
     }
 }

 class Solution {
     public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
         if (root == null) {
             return null;
         }
         if (root.val <= p.val) {
             return inorderSuccessor(root.right, p);
         } else {
             TreeNode candidate = inorderSuccessor(root.left, p);
             return candidate == null ? root : candidate;
         }
     }
 }
