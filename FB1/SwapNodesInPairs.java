/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        tail.next = head;

        while (tail.next != null && tail.next.next != null) {
            ListNode temp = tail.next.next.next;
            ListNode cur = tail.next;
            tail.next = cur.next;
            tail.next.next = cur;
            cur.next = temp;
            tail = cur;
        }
        return dummy.next;
    }
}
