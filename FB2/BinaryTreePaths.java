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
        List<String> lPaths = binaryTreePaths(root.left);
        List<String> rPaths = binaryTreePaths(root.right);
        for (String path : lPaths) {
            path = root.val + "->" + path;
            result.add(path);
        }
        for (String path : rPaths) {
            path = root.val + "->" + path;
            result.add(path);
        }
        if (result.size() == 0) {
            result.add(String.valueOf(root.val));
        }
        return result;
    }
}
