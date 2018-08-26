/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return root;
        }

        Node leftPart = treeToDoublyList(root.left);
        Node rightPart = treeToDoublyList(root.right);
        root.left = root;
        root.right = root;
        return connect(connect(leftPart, root), rightPart);
    }

    private Node connect(Node node1, Node node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        Node tail1 = node1.left;
        Node tail2 = node2.left;
        tail1.right = node2;
        node2.left = tail1;
        tail2.right = node1;
        node1.left = tail2;
        return node1;
    }
}
