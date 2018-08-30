/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        Node cur = head;
        while (cur != null) {
            if (cur.child == null) {
                cur = cur.next;
                continue;
            }
            Node temp = cur.child;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = cur.next;
            if (cur.next != null) {
                cur.next.prev = temp;
            }
            cur.next = cur.child;
            cur.child.prev = cur;
            cur.child = null;
            cur = cur.next;
        }
        return head;
    }
}
