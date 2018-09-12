/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
// LC110
 // no need for Pair class
 class Solution {
     boolean isBalanced = true;
     public boolean isBalanced(TreeNode root) {
         if (root == null) {
             return true;
         }
         int leftD = findDepth(root.left);
         int rightD =findDepth(root.right);
         if (Math.abs(leftD - rightD) > 1) {
             return false;
         }
         return isBalanced;
     }

     private int findDepth(TreeNode root) {
         if (root == null) {
             return 0;
         }

         int leftD = findDepth(root.left);
         int rightD = findDepth(root.right);

         if (Math.abs(leftD - rightD) > 1){
             isBalanced = false;
         }
         return Math.max(leftD, rightD) + 1;
     }
 }

class Pair {
    int height;
    boolean isBalanced;
    Pair(int h, boolean balanced) {
        height = h;
        isBalanced = balanced;
    }
}
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */

    public boolean isBalanced (TreeNode root) {
        if (root == null) {
            return true;
        }

        return helper(root).isBalanced;
    }

    private Pair helper(TreeNode root) {
        if (root == null) {
            return new Pair(0, true);
        }

        Pair leftSub = helper(root.left);
        Pair rightSub = helper(root.right);
        if (!leftSub.isBalanced || !rightSub.isBalanced) {
            return new Pair(0, false);
        }
        if (Math.abs(leftSub.height - rightSub.height) > 1) {
            return new Pair(0, false);
        }
        return new Pair(Math.max(leftSub.height, rightSub.height) + 1, true);
    }
}
