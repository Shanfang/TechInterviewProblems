import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int v) {
        this.val = v;
    }
}
class SumOfSubtree {
    static void sum (TreeNode root) {
        if (root == null) {
            return;
        }
        Map<TreeNode, Integer> map = new HashMap<>();
        helper(root, map);
        for (TreeNode node : map.keySet()) {
            System.out.println(node.val + " -- " + map.get(node));
        }
    }

    private static int helper(TreeNode node, Map<TreeNode, Integer> map) {
        if (node == null) {
            return 0;
        }
        int leftSum = helper(node.left, map);
        int rightSum = helper(node.right, map);
        int sum = leftSum + rightSum + node.val;
        map.put(node, sum);
        return sum;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        sum(node1);
    }
}
