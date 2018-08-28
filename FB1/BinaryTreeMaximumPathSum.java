/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


 /*
  the difference btw this problem and diameter of binary tree is:
  for diameter, we want to extend to as more nodes as possible, so in the recursive call,
  the depth of left subtree is guaranteed to pass the left child, while the max path of left child
  does not guarantee this, since we will discard the result from left child if it is < 0
  (path DOES NOT NEED to be from leaf--leaf).
  However, if all nodes are with positive values, then we can process it like diameter of bianry tree.
  Take whatever value returned from left child, no need to decide wheter we should discard(since it is > 0).

 */
class Solution {
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        pathCrossRoot(root);
        return maxSum;
    }

    private int pathCrossRoot(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int leftP = Math.max(0, pathCrossRoot(root.left)); //0 means we discard the left child
        int rightP = Math.max(0, pathCrossRoot(root.right));
        maxSum = Math.max(maxSum, leftP + rightP + root.val);
        return Math.max(leftP, rightP) + root.val;
    }
}
