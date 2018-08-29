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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        List<Integer> leftPart = preorderTraversal(root.left);
        List<Integer> rightPart = preorderTraversal(root.right);
        result.add(root.val);
        for (int num : leftPart) {
            result.add(num);
        }
        for (int num : rightPart) {
            result.add(num);
        }
        return result;
    }
}
