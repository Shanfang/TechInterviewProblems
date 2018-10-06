import java.util.*;

class BuildTree {
    class TreeNode {
        Character val;
        TreeNode left;
        TreeNode right;
        TreeNode(Character c) {
            this.val = c;
        }
    }
    public TreeNode buildTree(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        Queue<Character> queue = new LinkedList<>();
        for (char c : str.toCharArray()) {
            queue.offer(c);
        }
        return helper(queue);
    }

    // assume the leaf node only contains number < 10
    private TreeNode helper(Queue<Character> queue) {
        char c = queue.poll();

        if (Character.isDigit(c)) {
            return new TreeNode(c);
        }

        TreeNode root = new TreeNode(c);
        root.left = helper(queue);
        root.right = helper(queue);
        return root;
    }
    private void printTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                System.out.println(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
    }
    public static void main(String[] args) {
        String str = "+++1+2+3456";
        BuildTree builder = new BuildTree();
        TreeNode root = builder.buildTree(str);
        builder.printTree(root);
    }
}
