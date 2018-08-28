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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(sb, root);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<String>(Arrays.asList(data.split("#")));
        return buildTree(queue);
    }

    // build string using preorder traversal
    private void buildString(StringBuilder sb, TreeNode root) {
        if (root == null) {
            sb.append("NULL").append("#");
            return;
        }
        sb.append(root.val).append("#");
        buildString(sb, root.left);
        buildString(sb, root.right);
    }

    private TreeNode buildTree(Queue<String> queue) {
        String str = queue.poll();
        if (str.equals("NULL")) {
            return null;
        }
        TreeNode head = new TreeNode(Integer.valueOf(str));
        TreeNode leftChild = buildTree(queue);
        TreeNode rightChild = buildTree(queue);
        head.left = leftChild;
        head.right = rightChild;
        return head;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
