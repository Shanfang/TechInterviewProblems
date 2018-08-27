/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 /**
  * Definition for singly-linked list.
  * public class ListNode {
  *     int val;
  *     ListNode next;
  *     ListNode(int x) { val = x; }
  * }
  */
  // iterate list from back with the help of stack
 class Solution {
     public void reorderList(ListNode head) {
         Stack<ListNode> stack = new Stack<>();
         ListNode cur = head;
         while (cur != null) {
             stack.push(cur);
             cur = cur.next;
         }

         int counts = stack.size();
         cur = head;
         while (stack.size() > (counts + 1) / 2) {
             ListNode top = stack.pop();
             ListNode temp = cur.next;
             cur.next = top;
             top.next = temp;
             cur = temp;
         }
         if (cur != null) {
             cur.next = null;
         }
     }
 }


// find middle node, then do the merge
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode mid = findMiddle(head);
        ListNode tail = reverse(mid.next);
        mid.next = null;
        merge(head, tail);
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    private void merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(-1);
        int index = 0;
        while (head1 != null && head2 != null) {
            if (index % 2 == 0) {
                dummy.next = head1;
                head1 = head1.next;
            } else {
                dummy.next = head2;
                head2 = head2.next;
            }
            dummy = dummy.next;
            index++;
        }

        if (head1 != null) {
            dummy.next = head1;
        }
        if (head2 != null) {
            dummy.next = head2;
        }
    }
}
