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
