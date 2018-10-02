import java.util.*;

class RedundancyInLinkedList {
    static class Node {
        int val;
        Node next;
        Node (int value) {
            this.val = value;
            next = null;
        }
    }

    static Node removeDup(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node pre = new Node (-1);
        Node cur = head;

        Map<Integer, Integer> map = new HashMap<>();
        while (cur != null) {
            if (map.get(cur.val) != null) {
                pre.next = cur.next;
            } else {
                map.put(cur.val, 1);
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(2);
        Node node4 = new Node(3);
        Node node5 = new Node(3);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Node node = removeDup(head);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
