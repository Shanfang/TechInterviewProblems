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


// use recursion
/*
be careful that a valid ends at a node only if both of its left and right children are null
if one of the child is non-null, then we need to go deep to find the end of path!!! 
*/
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        recursion(root, "", result);
        return result;
    }

    private void recursion(TreeNode root, String path, List<String> result) {
        if (root.left == null && root.right == null) {
            path = path + root.val;
            result.add(path);
            return;
        }
        path += root.val + "->";
        if (root.left != null) {
            recursion(root.left, path, result);
        }
        if (root.right != null) {
            recursion(root.right, path, result);
        }
    }
}
