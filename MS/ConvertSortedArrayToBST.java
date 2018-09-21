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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = low + (high - low) / 2;
        TreeNode leftChild = buildTree(nums, low, mid - 1);
        TreeNode rightChild = buildTree(nums, mid + 1, high);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = leftChild;
        root.right = rightChild;
        return root;
    }
}
