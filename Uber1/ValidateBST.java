/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // BST inorder traversal
 class Solution {
     public boolean isValidBST(TreeNode root) {
         if (root == null) {
             return true;
         }

         Stack<TreeNode> stack = new Stack<>();
         TreeNode node = root;
         TreeNode pre = null;
         while (!stack.isEmpty() || node != null) {
             while (node != null) {
                 stack.push(node);
                 node = node.left;
             }

             node = stack.pop();
             if (pre != null && pre.val >= node.val) {
                 return false;
             }
             pre = node;
             node = node.right;
         }
         return true;
     }
 }

 // be careful about the secnario that one child is null
class Solution {
    class Triple {
        int minVal;
        int maxVal;
        boolean isValid;
        Triple(int min, int max, boolean valid) {
            minVal = min;
            maxVal = max;
            isValid = valid;
        }
    }
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Triple result = helper(root);
        return result.isValid;
    }

    private Triple helper(TreeNode root) {
        if (root == null) {
            return new Triple(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        }

        Triple leftRst = helper(root.left);
        Triple rightRst = helper(root.right);
        if (!leftRst.isValid || !rightRst.isValid) {
            return new Triple(0, 0, false);
        }

        if (root.left != null && leftRst.maxVal >= root.val || root.right != null && rightRst.minVal <= root.val) {
            return new Triple(0, 0, false);
        }
        return new Triple(Math.min(leftRst.minVal, root.val), Math.max(rightRst.maxVal, root.val), true);
    }
}
