/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;
        int count = 1;
        while (count < m) {
            head = head.next;
            count++;
        }
        ListNode preM = head;
        ListNode mth = preM.next;
        ListNode cur = head;
        ListNode nth = mth;
        ListNode postN = nth.next;

        while (count < n) {
            ListNode temp = postN.next;
            postN.next = nth;
            nth = postN;
            postN = temp;
            count++;
        }

        preM.next = nth;
        mth.next = postN;

        return dummy.next;
    }
}
