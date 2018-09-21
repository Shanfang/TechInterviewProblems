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
    public int closestValue(TreeNode root, double target) {
        TreeNode pre = null;
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            if (pre == null && target <= cur.val) {
                return cur.val;
            }
            if (pre != null && pre.val <= target && target <= cur.val) {
                return target - pre.val < cur.val - target ? pre.val : cur.val;
            }
            pre = cur;
            cur = cur.right;
        }
        return pre.val;
    }
}
