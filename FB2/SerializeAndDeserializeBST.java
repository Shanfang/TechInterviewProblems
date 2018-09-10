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
        if (data.length() == 0) {
            return null;
        }
        String[] strs = data.split("#");
        int[] position = new int[1];
        position[0] = 0;
        return helper(strs, position, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }


    private void buildString(StringBuilder sb, TreeNode root) {
        if (root == null) {
            return;
        }
        sb.append(root.val).append("#");
        buildString(sb, root.left);
        buildString(sb, root.right);
    }

    private TreeNode helper(String[] nodes, int[] pos, int low, int high) {
        if (pos[0] == nodes.length) {
            return null;
        }

        int val = Integer.valueOf(nodes[pos[0]]);
        if (val > high || val < low) {
            return null;
        }

        TreeNode root = new TreeNode(val);
        pos[0]++;
        root.left = helper(nodes, pos, low, val);
        root.right = helper(nodes, pos, val, high);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
