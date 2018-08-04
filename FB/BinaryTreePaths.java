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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        helper(root, "", result);
        return result;
    }
    private void helper(TreeNode node, String path, List<String> result) {
        if (node.left == null && node.right == null) {
            path = path + node.val;
            result.add(path);
        }
        path = path + node.val + "->";
        if (node.left != null) {
            helper(node.left, path, result);
        }
        if (node.right != null) {
            helper(node.right, path, result);
        }
    }
}
