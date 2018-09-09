/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
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
     class Triple {
         int minVal;
         int maxVal;
         boolean valid;
         Triple(int min, int max, boolean isValid) {
             minVal = min;
             maxVal = max;
             valid = isValid;
         }
     }
     public boolean isValidBST(TreeNode root) {
         if (root == null) {
             return true;
         }
         return helper(root).valid;
     }

     private Triple helper(TreeNode root) {
         if (root == null) {
             return new Triple(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
         }

         Triple leftSub = helper(root.left);
         Triple rightSub = helper(root.right);
         if (!leftSub.valid || !rightSub.valid)  {
              return new Triple(0, 0, false);
         }
         if ((root.left != null && leftSub.maxVal >= root.val) ||
             (root.right != null && rightSub.minVal <= root.val)) {
               return new Triple(0, 0, false);
         }
         // DO NOT use the combination condition to validate
         // 1. if any subtree return false, then reurn false
         // 2. if any subtree break the rule, returl false
         // 3. all other cases are valid
         // boolean allValid = leftSub.valid || rightSub.valid ||
         //                    (root.left != null && leftSub.maxVal >= root.val) ||
         //                    (root.right != null && rightSub.minVal <= root.val);
         // if (!allValid) {
         //     return new Triple(0, 0, false);
         // }
         return new Triple(Math.min(root.val, leftSub.minVal), Math.max(root.val, rightSub.maxVal), true);
     }
 }

// use inorder traversal
class Solution {
   public boolean isValidBST(TreeNode root) {
       if (root == null) {
           return true;
       }

       Stack<TreeNode> stack = new Stack<>();
       TreeNode pre = null;
       TreeNode node = root;
       while(node != null || !stack.isEmpty()) {
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
