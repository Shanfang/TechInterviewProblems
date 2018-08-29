/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 // iterative approach
 class Solution {
     public List<Integer> inorderTraversal(TreeNode root) {
         List<Integer> result = new ArrayList<>();
         if (root == null) {
             return result;
         }
         Stack<TreeNode> stack = new Stack<>();
         while (!stack.isEmpty() || root != null) {
             while (root != null) {
                 stack.push(root);
                 root = root.left;
             }
             root = stack.pop();
             result.add(root.val);
             root = root.right;
         }
         return result;
     }
 }

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        List<Integer> leftP = inorderTraversal(root.left);
        List<Integer> rightP = inorderTraversal(root.right);
        for (int num : leftP) {
            result.add(num);
        }
        result.add(root.val);
        for (int num : rightP) {
            result.add(num);
        }
        return result;
    }
}
