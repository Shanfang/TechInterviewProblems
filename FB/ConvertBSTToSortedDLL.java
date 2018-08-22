
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
// divide and conquer approach
class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return root;
        }

        Node leftHead = treeToDoublyList(root.left);
        Node rightHead = treeToDoublyList(root.right);

        // make root a DLL
        root.left = root;
        root.right = root;

        // now we get 3 DLL, connect them
        return connect(connect(leftHead, root), rightHead);
    }

    private Node connect(Node node1, Node node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }

        // find the tail of each part using their corresponding head
        Node tail1 = node1.left;
        Node tail2 = node2.left;

        tail1.right = node2;
        node2.left = tail1;
        tail2.right = node1;
        node1.left = tail2;
        return node1;
    }
}

// iterative approach
class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }

        // find the smallest node in the tree
        Node head = root;
        while (head.left != null) {
            head = head.left;
        }

        Stack<Node> stack = new Stack<>();
        Node cur = root;
        Node pre = null;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            if (pre != null) {
                pre.right = cur;
                cur.left = pre;
            }
            pre = cur;
            cur = cur.right;
        }
        head.left = pre;
        pre.right = head;
        return head;
    }
}
