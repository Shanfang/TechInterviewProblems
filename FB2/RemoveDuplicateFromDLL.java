// keep the last one of the duplicates
public void removeDuplicateFromDoublyLinkedList(ListNode head) {
    if (head == null) {
        return;
    }

    ListNode dummyHead = new ListNode(-1);
    dummyHead.next = head;
    head.pre = dummyHead;
    Map<Integer, ListNode> map = new HashMap<>();

    ListNode cur = head;
    while (cur != null) {
        if (map.containsKey(cur.val)) {
            ListNode dup = map.get(cur.val);
            dup.pre.next = dup.next;
            dup.next.pre = dup.pre;
        }
        map.put(cur.val, cur);
        cur = cur.next;
    }
    head.pre = null;
}
