/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // non-recursive approach with BFS
  class Solution {
     public List<String> binaryTreePaths(TreeNode root) {
         List<String> result = new ArrayList<>();
         if (root == null) {
             return result;
         }
         Queue<TreeNode> nodeQ = new LinkedList<>();
         Queue<String> pathQ = new LinkedList<>();
         nodeQ.offer(root);
         pathQ.offer("" + root.val);
         while (!nodeQ.isEmpty()) {
             TreeNode node = nodeQ.poll();
             String path = pathQ.poll();
             if (node.left == null && node.right == null) {
                 result.add(path);
             }

             if (node.left != null) {
                 nodeQ.offer(node.left);
                 pathQ.offer(path + "->" + node.left.val);
             }
             if (node.right != null) {
                 nodeQ.offer(node.right);
                 pathQ.offer(path + "->" + node.right.val);
             }
         }
         return result;
     }
 }
 // stringbuilder issue resolved!!!
 class Solution {
     public List<String> binaryTreePaths(TreeNode root) {
         List<String> result = new ArrayList<>();
         if (root == null) {
             return result;
         }
         helper(root, new StringBuilder(), result);
         return result;
     }
     private void helper(TreeNode root, StringBuilder sb, List<String> result) {
         int len = sb.length();

         if (root.left == null && root.right == null) {
             result.add(sb.append(root.val).toString());
             sb.delete(len, sb.length());
             return;
         }

         sb.append(root.val).append("->");
         if (root.left != null) {
            helper(root.left, sb, result);
         }
         if (root.right != null) {
            helper(root.right, sb, result);
         }
         sb.delete(len, sb.length());
     }
 }
 // recursive approach
// 1. a binary tree path is from root to leaf node, for leaf node BOTH its left and right child should be null
// 2.(check the above solution, there is workaround) do not use stringbuilder here, we need to since there is no way to do a deep copy like arraylist, so the
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

 // simple divide and conquer approach
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
