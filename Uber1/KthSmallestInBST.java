/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// memoization for counting number of nodes
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
    Map<TreeNode, Integer> map = new HashMap<>();
    public int kthSmallest(TreeNode root, int k) {
        countNodes(root);
        map.put(null, 0);
        return helper(root, k);
    }

    private int helper(TreeNode root, int k) {
        int count = map.get(root.left);
        if (count + 1 == k) {
            return root.val;
        } else if (count + 1 > k) {
            return helper(root.left, k);
        } else {
            return helper(root.right, k - count - 1);
        }
    }
    private int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftCnt = countNodes(root.left);
        int rightCnt = countNodes(root.right);
        map.put(root, leftCnt + rightCnt + 1);
        return leftCnt + rightCnt + 1;
    }
}

 // inorder traversal
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int num = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            num++;
            if (num == k) {
                return node.val;
            }
            node = node.right;
        }
        return Integer.MIN_VALUE;
    }
}
