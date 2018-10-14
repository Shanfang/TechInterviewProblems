class LRUCache {
    int cap;
    Node head;
    Node tail;
    Map<Integer, Node> map;
    class Node {
        int key;
        int val;
        Node pre;
        Node next;
        Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }
    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.pre.next = node.next;
            node.next.pre = node.pre;
            moveToTail(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (get(key) != -1) {
            map.get(key).val = value;
        } else {
            if (map.size() == cap) {
                removeFirst();
            }
            Node node = new Node(key, value);
            map.put(key, node);
            moveToTail(node);
        }
    }

    private void moveToTail(Node node) {
        tail.pre.next = node;
        node.pre = tail.pre;
        tail.pre = node;
        node.next = tail;
    }

    private void removeFirst() {
        map.remove(head.next.key);
        head.next = head.next.next;
        head.next.pre = head;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
