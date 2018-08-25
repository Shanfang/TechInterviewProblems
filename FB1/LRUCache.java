class LRUCache {
    class Node {
        int val;
        int key;
        Node next;
        Node pre;
        Node(int k, int v) {
            this.key = k;
            this.val = v;
            next = null;
            pre = null;
        }
    }
    Map<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
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
            if (map.size() == capacity) {
                removeFirst();
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            moveToTail(newNode);
        }
    }

    private void moveToTail(Node node) {
        tail.pre.next = node;
        node.pre = tail.pre;
        node.next = tail;
        tail.pre = node;
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


// !!! Attention: this works only if the two numbers in k-v pair are same
class LRUCache {
    class Node {
        int val;
        Node next;
        Node pre;
        Node(int value) {
            val = value;
            next = null;
            pre = null;
        }
    }
    Map<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.pre.next = node.next;
            node.next.pre = node.pre;
            moveToTail(node);
            return key;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (get(key) != -1) {
            Node original = map.get(key);
            if (original.val != value) {
                original.val = value;
            }
        } else {
            if (map.size() == capacity) {
                removeFirst();
            }
            Node newNode = new Node(value);
            map.put(key, newNode);
            moveToTail(newNode);
        }
    }

    private void moveToTail(Node node) {
        tail.pre.next = node;
        node.pre = tail.pre;
        node.next = tail;
        tail.pre = node;
    }

    private void removeFirst() {
        map.remove(head.next.val);
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
