/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // use hash set
 class Solution {
     public boolean findTarget(TreeNode root, int k) {
         Set<Integer> set = new HashSet<>();
         return find(root, k, set);
     }
     private boolean find(TreeNode root, int k, Set<Integer> set) {
         if (root == null) {
             return false;
         }
         if (set.contains(k - root.val)) {
             return true;
         }
         set.add(root.val);
         return find(root.left, k, set) || find(root.right, k, set);
     }
 }

 // use BST inorder traversal
 class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        List<Integer> list = new ArrayList<>();
        inorder(list, root);

        int i = 0, j = list.size() - 1;
        while (i < j) {
            int sum = list.get(i) + list.get(j);
            if (sum == k) {
                return true;
            } else if (sum < k) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    private void inorder(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(list, root.left);
        list.add(root.val);
        inorder(list, root.right);
    }
}
