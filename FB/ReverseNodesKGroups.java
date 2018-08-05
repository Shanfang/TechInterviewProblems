/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        int count = 0;
        ListNode pre = head;
        while (count < k && pre != null) {
            pre = pre.next;
            count++;
        }
        if (count < k) {
            return head;
        }

        ListNode newHead = reverseKGroup(pre, k);
        pre = newHead;
        ListNode post = head;
        while (count > 0) {
            ListNode temp = post.next;
            post.next = pre;
            pre = post;
            post = temp;
            count--;
        }
        return pre;
    }
}
