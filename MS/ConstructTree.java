import java.util.*;

class TreeNode {
    String val;
    TreeNode left;
    TreeNode right;
    TreeNode(String v) {
        this.val = v;
    }
}
class ConstructTree {
    static TreeNode buildTree(String[][] table) {
        if (table == null || table.length == 0 || table[0].length == 0) {
            return null;
        }
        Map<String, TreeNode> map = new HashMap<>();
        for (String[] row : table) {
            TreeNode node = new TreeNode(row[2]);
            map.put(row[1], node);
        }

        TreeNode root = null;
        for (String[] row : table) {
            String parent = row[0];
            String cur = row[1];
            if (parent != null) {
                TreeNode parentNode  = map.get(parent);
                if (parentNode.left == null) {
                    parentNode.left = map.get(cur);
                } else {
                    parentNode.right = map.get(cur);
                }
            } else {
                root = map.get(cur);
            }
        }
        return root;
    }
    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                System.out.print(head.val + "\t");
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        String[][] table = new String[][]{
            {null, "1", "one"},
            {"1", "2", "two"},
            {"1", "4", "four"},
            {"2", "3", "three"},
            {"4", "5", "five"}};
        printTree(buildTree(table));
        //System.out.println(buildTree(table).val);
    }
}
