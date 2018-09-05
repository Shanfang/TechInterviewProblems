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

 // attach two lists to check if circle exists
 public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode cur = headA;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = headB;

        ListNode node = circleDetect(headA);
        cur.next = null;
        return node != null ? node : null;
    }

    private ListNode circleDetect(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = head;
        fast = fast.next;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}

 // count length then walk long list ahead of time
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
