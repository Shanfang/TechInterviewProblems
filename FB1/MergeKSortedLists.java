/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        Queue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });

        for (ListNode head : lists) {
            if (head != null) {
                queue.offer(head);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode preHead = dummy;
        while (!queue.isEmpty()) {
            ListNode cur = queue.poll();
            dummy.next = cur;
            dummy = dummy.next;
            if (cur.next != null) {
                queue.offer(cur.next);
            }
        }
        return preHead.next;
    }
}
