import java.util.*;

class Node {
    int val;
    Node next;
    Node pre;
    Node(int v) {
        this.val = v;
        this.next = null;
        this.pre = null;
    }
}
class ImplementQueue {
    Node head;
    Node tail;
    ImplementQueue() {
        head = null;
        tail = null;
    }

    Node enqueue(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.pre = node;
            head = node;
        }
        return node;
    }

    Node dequeue() {
        if (tail == null) {
            return null;
        } else {
            Node temp = tail;
            tail = tail.pre;
            tail.next = null;
            temp.pre = null;
            return temp;
        }
    }

    public static void main(String[] args) {
        ImplementQueue queue = new ImplementQueue();
        System.out.println(queue.enqueue(1).val);
        System.out.println(queue.enqueue(2).val);
        System.out.println(queue.enqueue(3).val);
        System.out.println(queue.enqueue(4).val);
        System.out.println(queue.dequeue().val);
        Node cur = queue.head;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }

    }
}
