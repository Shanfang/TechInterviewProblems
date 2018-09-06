/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    Queue<String> queue;
    Stack<TreeNode> stack;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                sb.append(node.val).append(",");
                stack.push(node.right);
                stack.push(node.left);
            } else {
                sb.append("NULL").append(",");
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        queue = new LinkedList<>();
        String[] strs = data.split(",");

        for (String str : strs) {
            queue.offer(str);
        }
        // queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return buildTree(queue);
    }

    private TreeNode buildTree(Queue<String> queue) {
        String str = queue.poll();
        if (str.equals("NULL")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(str));
        TreeNode leftTree = buildTree(queue);
        TreeNode rightTree = buildTree(queue);
        root.left = leftTree;
        root.right = rightTree;
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
