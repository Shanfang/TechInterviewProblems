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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = traversal(root);
        int i = 0, j = list.size() - 1;
        while (i < j) {
            int num1 = list.get(i);
            int num2  = list.get(j);
            if (num1 + num2 == k) {
                return true;
            } else if (num1 + num2 < k) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    private List<Integer> traversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> lList = traversal(root.left);
        List<Integer> rList = traversal(root.right);
        for (int num : lList) {
            result.add(num);
        }
        result.add(root.val);
        for (int num : rList) {
            result.add(num);
        }
        return result;
    }
}

// same idea as two sum in sorted array
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null){
            return false;
        }

        Set<Integer> set = new HashSet<>();
        return helper(root, k, set);
    }

    private boolean helper(TreeNode root, int k, Set<Integer> set) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);

        return helper(root.left, k, set) || helper(root.right, k, set);
    }
}
