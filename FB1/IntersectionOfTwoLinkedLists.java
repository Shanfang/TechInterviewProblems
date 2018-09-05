/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        int lenA = findLength(headA);
        int lenB = findLength(headB);
        if (lenA > lenB) {
            return walkList(headA, headB, lenA - lenB);
        }
        return walkList(headB, headA, lenB - lenA);
    }

    private int findLength(ListNode head) {
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        return len;
    }

    private ListNode walkList(ListNode head1, ListNode head2, int steps) {
        while (steps > 0) {
            head1 = head1.next;
            steps--;
        }
        ListNode result = null;
        while (head1 != null) {
            if (head1 == head2) {
                result = head1;
                break;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return result;
    }
}
