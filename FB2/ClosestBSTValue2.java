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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> result = new ArrayList<>();
        if (root == null || k <= 0) {
            return result;
        }
        Stack<TreeNode> preStack = new Stack<>();
        Stack<TreeNode> sucStack = new Stack<>();
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val < target) {
                preStack.push(cur);
                cur = cur.right;
            } else {
                sucStack.push(cur);
                cur = cur.left;
            }
        }

        while (result.size() < k) {
            double diffPre = preStack.isEmpty() ? Double.MAX_VALUE : Math.abs(target - preStack.peek().val);
            double diffSuc = sucStack.isEmpty() ? Double.MAX_VALUE : Math.abs(sucStack.peek().val - target);
            if (diffPre < diffSuc) {
                result.add(0, preStack.peek().val);
                getPre(preStack);
            } else {
                result.add(sucStack.peek().val);
                getNext(sucStack);
            }
        }
        return result;
    }

    private void getPre(Stack<TreeNode> stack) {
        TreeNode cur = stack.pop().left;
        while (cur != null) {
            stack.push(cur);
            cur = cur.right;
        }
    }

    private void getNext(Stack<TreeNode> stack) {
        TreeNode cur = stack.pop().right;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
    }
}
