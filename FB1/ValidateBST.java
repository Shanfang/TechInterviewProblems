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

  // can't use a global variale isBST, and update it while tracking down the tree.
  // different from diamter of tree, where maxDiameter can be updated by any node,
  // here isBST shoulb be more strict of AND instead of OR relation
 class Solution {
     class Triple {
         int maxVal;
         int minVal;
         boolean isBST;
         Triple(int max, int min, boolean isValid) {
             maxVal = max;
             minVal = min;
             isBST = isValid;
         }
     }

     public boolean isValidBST(TreeNode root) {
         if (root == null) {
             return true;
         }
         return helper(root).isBST;
     }

     private Triple helper(TreeNode root) {
         if (root == null) {
             return new Triple (Integer.MIN_VALUE, Integer.MAX_VALUE, true);
         }
          Triple leftP = helper(root.left);
         Triple rightP = helper(root.right);
         if (!leftP.isBST || !rightP.isBST) {
             return new Triple(Integer.MIN_VALUE, Integer.MAX_VALUE,false);
         }
         if ((root.left != null && leftP.maxVal >= root.val) || (root.right != null && root.val >= rightP.minVal)) {
             return new Triple(Integer.MIN_VALUE, Integer.MAX_VALUE, false);
         }
         return new Triple(Math.max(root.val, rightP.maxVal), Math.min(root.val, leftP.minVal), true);
     }
 }


// inorder traversal
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && pre.val >= root.val) {
                return false;
            }
            pre = root;
            root = root.right;
        }
        return true;
    }
}
