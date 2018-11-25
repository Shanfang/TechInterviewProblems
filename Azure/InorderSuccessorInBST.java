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
     TreeNode successor = null;
     public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
         if (root == null) {
             return successor;
         }
         if (root.val > p.val) {
             successor = root;
             inorderSuccessor(root.left, p);
         } else if (root.val <= p.val) {
             inorderSuccessor(root.right, p);
         }
         return successor;
     }
 }

 // tree traversal
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (pre == p) {
                return cur;
            }
            pre = cur;
            cur = cur.right;
        }
        return null;
    }
}
