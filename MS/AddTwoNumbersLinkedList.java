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
         if (l1 == null) {
             return l2;
         }
         if (l2 == null) {
             return l1;
         }
         ListNode dummy = new ListNode(-1);
         ListNode cur = dummy;
         int sum = 0;
         while (l1 != null || l2 != null) {
             if (l1 != null) {
                 sum += l1.val;
                 l1 = l1.next;
             }
             if (l2 != null) {
                 sum += l2.val;
                 l2 = l2.next;
             }
             cur.next = new ListNode(sum % 10);
             cur = cur.next;
             sum /= 10;
         }
         if (sum != 0) {
             cur.next = new ListNode(sum);
         }
         return dummy.next;
     }
 }


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int num1 = 0;
        int num2 = 0;
        int sum = 0;
        int carry = 0;
        while (l1 != null || l2 != null) {
            num1 = l1 == null ? num1 = 0 : l1.val;
            num2 = l2 == null ? num2 = 0 : l2.val;
            sum = num1 + num2 + carry;
            ListNode node = new ListNode(sum % 10);
            cur.next = node;
            cur = node;
            carry = sum / 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (carry != 0) {
            cur.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
