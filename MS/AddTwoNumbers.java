/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry  = 0;
        ListNode preHead = new ListNode(-1);
        ListNode dummy = preHead;

        while (l1 != null || l2 != null) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            int num = num1 + num2 + carry;
            ListNode node = new ListNode(num % 10);
            carry = num / 10;
            dummy.next = node;
            dummy = node;
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }
        if (carry != 0) {
            dummy.next = new ListNode(carry);
        }
        return preHead.next;
    }
}
