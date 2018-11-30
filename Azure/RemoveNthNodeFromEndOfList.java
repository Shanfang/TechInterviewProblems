/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        pre.next = head;
        for (int i = 0; i < n; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        } // now head is pointing to the node before the one that will be removed

        while (head != null) {
            pre = pre.next;
            head = head.next;
        }
        pre.next = pre.next.next;
        return dummy.next;
    }
}
