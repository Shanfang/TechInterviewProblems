import java.util.*;

class Node {
    int val;
    Node next;
    Node(int v) {
        this.val = v;
    }
}
class ReversePrintList {
    static String print(Node head) {
        if (head == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        helper(head, sb);
        return sb.toString();
    }
    static void helper(Node head, StringBuilder sb) {
        if (head.next == null) {
            sb.append(head.val);
            return;
        }
        helper(head.next, sb);
        sb.append(head.val);
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        System.out.println(print(n1));
    }
}
