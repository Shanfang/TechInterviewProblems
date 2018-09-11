/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 1. a binary tree path is from root to leaf node, for leaf node BOTH its left and right child should be null
// 2. do not use stringbuilder here, we need to since there is no way to do a deep copy like arraylist, so the
// path from left subtree will pesent in rightsubtree!!
// 3. for bianry tree path and depth. All end at leaf node, so if only one child is null, do not stop
  class Solution {
      public List<String> binaryTreePaths(TreeNode root) {
          List<String> result = new ArrayList<>();
          if (root == null) {
              return result;
          }
          helper(root, "", result);
          return result;
      }
      private void helper(TreeNode root, String str, List<String> result) {
          if (root.left == null && root.right == null) {
              result.add(str + root.val);
              return;
          }

          String path = str + root.val + "->";
          if (root.left != null) {
             helper(root.left, path, result);
          }
          if (root.right != null) {
             helper(root.right, path, result);
          }
      }
  }

 // simple recursive approach
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
