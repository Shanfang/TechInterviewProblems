/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// one pass, first pointer move (n + 1) steps, then when firt poitner is null
// the second pointer is in front of the node to be removed

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode preDelete = dummy;
        for (int i = 0; i < n; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }
        while (head != null) {
            head = head.next;
            preDelete = preDelete.next;
        }
        preDelete.next = preDelete.next.next;
        return dummy.next;
    }
}

 // find the length of the list first, two pass
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = getLength(head);
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        dummy.next = head;
        int count = 0;
        while (count < len - n) {
            cur = cur.next;
            count++;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }

    private int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }
}
